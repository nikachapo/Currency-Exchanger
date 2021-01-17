import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.List;

public class Launcher extends Application implements MainPresenter.Listeners{

    private static MainPresenter presenter;

    public static Button exchangeBtn;
    public static Label resultLabel;
    public static TextField amountField;
    public static ChoiceBox<String> choice_to;
    public static ChoiceBox<String> choice_from;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        presenter = new MainPresenter(this);
        choice_from = new ChoiceBox<>();
        choice_from.setLayoutX(80);
        choice_from.setLayoutY(150);
        choice_from.setPrefWidth(150);

        choice_to = new ChoiceBox<>();
        choice_to.setLayoutX(360);
        choice_to.setLayoutY(150);
        choice_to.setPrefWidth(150);

        exchangeBtn = new Button("Exchange");
        exchangeBtn.setLayoutX(270);
        exchangeBtn.setLayoutY(300);
        exchangeBtn.setOnAction(event -> {
            String from = choice_from.getValue();
            String to = choice_to.getValue();
            String amount = amountField.getText();
            presenter.calculate(from, to, amount);
        });

        amountField = new TextField();
        amountField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                amountField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        amountField.setPromptText("Amount");
        amountField.setLayoutX(225);
        amountField.setLayoutY(215);

        resultLabel = new Label();
        resultLabel.setLayoutX(260);
        resultLabel.setLayoutY(255);

        AnchorPane vBox = new AnchorPane();
        vBox.getChildren().addAll(choice_from, choice_to, exchangeBtn, amountField, resultLabel);

        Scene scene = new Scene(vBox, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Currency Exchanger");
        primaryStage.show();
    }

    @Override
    public void onCurrenciesReceived(List<String> currencyNames) {
        ObservableList<String> list = FXCollections.observableArrayList(currencyNames);
        choice_from.setItems(list);
        choice_to.setItems(list);
        choice_from.getSelectionModel().selectFirst();
        choice_to.getSelectionModel().selectFirst();
    }

    @Override
    public void showMessage(String text) {
        Alert alert = new Alert(Alert.AlertType.WARNING, text);
        alert.showAndWait();
    }

    @Override
    public void resultReceived(String resultToDisplay) {
        resultLabel.setText(resultToDisplay);
    }
}

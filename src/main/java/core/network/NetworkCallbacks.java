package core.network;

public interface NetworkCallbacks<T> {

    void onSuccess(T obj);

    void onError(String msg);

}

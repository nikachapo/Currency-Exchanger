package core.usecases;

public interface UseCase<T> {

    default T invokeAndReturn() {return null;}
    default void invoke() {}

}

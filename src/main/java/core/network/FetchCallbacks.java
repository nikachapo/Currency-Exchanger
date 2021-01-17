package core.network;

public interface FetchCallbacks<T> {

    void onSuccess(T obj);

    void onError(String msg);

}

package mburakaltun.Northwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T data) {
        super(data, true);
    }

    public SuccessDataResult(String message, T data) {
        super(data, true, message);
    }
}

package sample.contract;

public class ErrorContract {

    private final int errorCode;
    private final String errorMessage;

    public ErrorContract(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.errorMessage;
    }
}

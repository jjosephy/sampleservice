package sampleservice;

public class ErrorContractV1 {

    private final int errorCode;
    private final String errorMessage;

    public ErrorContractV1(int errorCode, String errorMessage) {
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

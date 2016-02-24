package sample.contract;

public class ResponseContractV2 {

    private final double id;
    private final String content;
    private final String newValue;

    public ResponseContractV2() {
        id = 0;
        content = "";
        newValue = "";
    }

    public double getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

	public String getNewValue() {
		return newValue;
	}
}

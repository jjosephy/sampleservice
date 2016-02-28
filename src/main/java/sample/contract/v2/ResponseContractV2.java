package sample.contract.v2;

public class ResponseContractV2 {

    private final double id;
    private final String content;
    private String newValue;

    public ResponseContractV2(double id, String content, String newVal) {
        this.id = id;
        this.content = content;
        this.newValue = newVal;
    }

    public double getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public String getNewValue() {
    	return this.newValue;
    }
    
    public void setNewValue(String v) {
        this.newValue = v;
    }
}

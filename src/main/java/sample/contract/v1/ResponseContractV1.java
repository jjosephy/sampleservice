package sample.contract.v1;

public class ResponseContractV1 {

    private final double id;
    private final String content;

    public ResponseContractV1() {
        this.id = 0;
        this.content = "";
    }
    
    public ResponseContractV1(double id, String content) {
        this.id = id;
        this.content = content;
    }

    public double getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}

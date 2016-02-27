package sample.contract.v1;

public class ResponseContractV1_1 extends ResponseContractV1 {

    private final String custom;
    
    public ResponseContractV1_1(double id, String content) {
        super(id, content);
        this.custom = "custom";
    }
    
    public String getCustom() {
        return custom;
    }

}

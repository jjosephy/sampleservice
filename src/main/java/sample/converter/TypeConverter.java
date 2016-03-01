package sample.converter;

import sample.contract.v1.ResponseContractV1;
import sample.contract.v1.ResponseContractV1_1;
import sample.contract.v2.ResponseContractV2;
import sample.model.CanonicalDataModel;

public class TypeConverter {

    // Convert V1 Model to Contract
    public static ResponseContractV1 ConvertModelToContractV1(CanonicalDataModel model) {
        return new ResponseContractV1(1, model.getContent() + "_V1Content");
    }
    
    // Convert V1 Contract to Model
    public static CanonicalDataModel ConvertContractV1ToModel(ResponseContractV1 contract) {
        CanonicalDataModel model = new CanonicalDataModel();
        model.setContent(contract.getContent() + "_V1.1Content");
        return model;
    }
    
    // Convert V1.1 Model to Contract
    public static ResponseContractV1_1 ConvertModelToContractV1_1(CanonicalDataModel model) {
        return new ResponseContractV1_1(1.1, model.getContent() + "V2_Content");
    }
    
    // Convert V1.1 Contract to Model
    public static CanonicalDataModel ConvertContractV1_1ToModel(ResponseContractV1 contract) {
        CanonicalDataModel model = new CanonicalDataModel();
        model.setContent(contract.getContent());
        return model;
    }
    
    // Convert V2 Model to Contract
    public static ResponseContractV2 ConvertModelToContractV2(CanonicalDataModel model) {
        return new ResponseContractV2(2, model.getContent(), "v2 Content");
    }
    
    // Convert V2 Contract to Model
    public static CanonicalDataModel ConvertContractV2ToModel(ResponseContractV2 contract) {
        CanonicalDataModel model = new CanonicalDataModel();
        model.setContent(contract.getContent());
        return model;
    }
}

package sample.converter;

import sample.model.CanonicalDataModel;

public class TypeConverter {

    public static Object ConvertModelToContract(CanonicalDataModel model, Double version) {
        return new Object();
    }
    
    public static CanonicalDataModel ConvertContractToModel(Object contract) {
        return new CanonicalDataModel();
    }
}

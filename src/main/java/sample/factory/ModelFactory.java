package sample.factory;

import sample.model.CanonicalDataModel;

public class ModelFactory {
    public static CanonicalDataModel createModel() {
        return new CanonicalDataModel();
    }
}

package sample.model;

import java.util.Random;
import java.util.UUID;

public class CanonicalDataModel {

    private final UUID id;
    private final String content;
    private final int size;
    private String attributes = "";

    private static Random randomGenerator = new Random();
    
    public CanonicalDataModel() {
        this.id = UUID.randomUUID();
        this.content = "";
        this.size = randomGenerator.nextInt(10000);
    }
    
    public String getAttributes() {
        return this.attributes;
    }
    
    public void setAttributes(String val) {
        this.attributes = val;
    }
    
    public UUID getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }
    
    public int getSize() {
        return this.size;
    }
}

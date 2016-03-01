package sample.model;

import java.util.Random;
import java.util.UUID;

public class CanonicalDataModel {

    private final UUID id;
    private final int size;
    private String content;
    private String attributes = "";
    private String[] items;

    private static Random randomGenerator = new Random();
    
    public CanonicalDataModel() {
        this.id = UUID.randomUUID();
        this.content = this.generateRandomString();
        this.size = randomGenerator.nextInt(10000);
        this.items = new String[4];
        for (int i = 0; i < 4; i++) {
            this.items[i] = this.generateRandomString();
        }
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
    
    public void setContent(String v) {
        this.content = v;
    }
    
    public int getSize() {
        return this.size;
    }
    
    // TODO: better random string generator
    private String generateRandomString() {
        StringBuilder b = new StringBuilder();
        
        for (int idx = 0; idx < 10; ++idx) {
            char n = (char)randomGenerator.nextInt(100);
            b.append(n);
        }
          
        return b.toString();
    }
}

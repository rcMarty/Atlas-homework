package io.openliberty.guides.rest;


public class Document {
    private String docSsid;
    private Double cost;
    

    public Document(String docSsid,Double cost){
        this.docSsid = docSsid;
        this.cost = cost;
    }

    public String getDocSsid(){return docSsid;}
    public Double getCost(){return cost;}
        
}

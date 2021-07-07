// tag::comment[]
/*******************************************************************************
 * Copyright (c) 2017, 2019 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
// end::comment[]
package io.openliberty.guides.rest;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
 
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


 
// tag::path[]
//@RequestScoped
@Path("SortByBest")
// end::path[]
public class SortByBest {
 
    // tag::get[]
    @GET
    // end::get[]
    // tag::produces[]

    
    @Produces(MediaType.APPLICATION_JSON)
    // end::produces[]
    public Properties getProperties() {
        //return System.getProperties();
        Properties a = new Properties();
        a.setProperty("message", "hello sort by best");
        
        return a;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public List<Document> postFormData(String attachment){
    
        JsonReader jsonReader = Json.createReader(new StringReader(attachment));
        JsonObject json = jsonReader.readObject();
        jsonReader.close();

        List<Document> documents = new ArrayList<>();
        
        Double cost;
        List<Double> avgcost = new ArrayList<>();
        JsonArray jsondataarr = json.getJsonArray("data");  //pole dokumentu konkretne key==data

        for (int i = 0; i < jsondataarr.size(); i++) {
            JsonObject jsondocssid = jsondataarr.getJsonObject(i);  //jednotlivy objekt v poli dokumentu treba docssid:1soubor a users:pole uzivatelu
            JsonArray jsonusersarr = jsondocssid.getJsonArray("users"); //pole uzivatelu  

            for (int j = 0; j < jsonusersarr.size(); j++){
                JsonObject jsonusers = jsonusersarr.getJsonObject(j);   // jednotlivy uzivatel jakozto objekt
                
                cost = Algorithms.CalculateCost(jsonusers.getInt("views"),jsonusers.getInt("time"));   //vypocitani hodnoty(pocet otevreni dokumentu + (doba v sekundach co se na to dival / 1000)) kazdeho uzivatele
                avgcost.add(cost);
            }
            
            documents.add(new Document(jsondocssid.getString("docSsid"), Algorithms.CalcAvgCost(avgcost))); // finalni hodnota dokumentu
            avgcost.clear();
        }
       

        documents.sort((d2,d1) -> d1.getCost().compareTo(d2.getCost()));
        
        
        return documents;

    }

}

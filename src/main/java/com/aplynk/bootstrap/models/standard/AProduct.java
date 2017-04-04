package com.aplynk.bootstrap.models.standard;

import com.aplynk.bootstrap.blueprints.JsonModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Soumya on 05-12-2016.
 */

public class AProduct extends JsonModel {

    private String id;

    private String sku;

    private String name;

    private String description;

    @SerializedName("unit_price")
    private double unitPrice;

    @SerializedName("external_reference")
    private String externalReference;

    public void checkValidity() {
        if(!isValid()) {
            throw new RuntimeException("Product invalid");
        }
    }

    private boolean isValid() {
        return id != null && id.length() > 0 && name != null && name.length() > 0;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    @Override
    public String toString() {
        return toJson().toString();
    }

    @Override
    public JsonObject toJson() {
        return getJson(this);
    }
}

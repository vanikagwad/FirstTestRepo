package com.aplynk.bootstrap.models.standard;

import com.aplynk.bootstrap.blueprints.JsonModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Blaze on 09-02-2017.
 */

public class ADeal extends JsonModel {

    private String id;
    private String number;
    private String name;
    private Double amount;
    private String date;
    @SerializedName("closing_date")
    private String closingDate;
    private String stage;
    @SerializedName("external_reference")
    private String externalReference;
    private AAccount account;
    @SerializedName("currency_code")
    private String currencyCode;


    public void checkValidity() {
        if(!isValid()) {
            throw new RuntimeException("Deal invalid");
        }

        if(account != null) {
            account.checkValidity();
        }
    }

    private boolean isValid() {
        return amount != null && amount >= 0 && id != null && id.length() > 0;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public AAccount getAccount() {
        return account;
    }

    public void setAccount(AAccount account) {
        this.account = account;
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
package com.aplynk.bootstrap.models.standard;

import com.aplynk.bootstrap.blueprints.JsonModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Soumya on 05-12-2016.
 */
public class AAccount extends JsonModel {

    private String id;

    private String number;

    private String type;

    private String name;

    private String email;

    private String website;

    private String phone;

    @SerializedName("billing_address")
    private AAddress billingAddress;

    @SerializedName("shipping_address")
    private AAddress shippingAddress;

    private List<AContact> contacts;

    @SerializedName("external_reference")
    private String externalReference;

    public void checkValidity() {
        if(!isValid()) {
            throw new RuntimeException("Account invalid");
        }

        for (AContact contact: contacts) {
            contact.checkValidity();
        }
    }

    private boolean isValid() {
        return name != null && name.length() > 0 && id != null && id.length() > 0;
    }

    public List<AContact> getContacts() {
        return contacts;
    }

    public void setContacts(List<AContact> contacts) {
        this.contacts = contacts;
    }

    public AAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(AAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(AAddress billingAddress) {
        this.billingAddress = billingAddress;
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

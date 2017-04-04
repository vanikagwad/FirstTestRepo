package com.aplynk.bootstrap.models.standard;

import com.aplynk.bootstrap.blueprints.JsonModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Soumya on 05-12-2016.
 */

public class ALineItem extends JsonModel {
    private int quantity;

    @SerializedName("list_price")
    private double listPrice;

    @SerializedName("tax_code")
    private String taxCode;

    @SerializedName("tax_percentage")
    private double taxPercentage;

    @SerializedName("discount_code")
    private String discountCode;

    @SerializedName("discount_percentage")
    private double discountPercentage;

    @SerializedName("sub_total")
    private double subTotal;

    @SerializedName("tax_total")
    private double taxTotal;

    private double total;

    @SerializedName("external_reference")
    private String externalReference;

    private AProduct product;

    public void checkValidity() {
        if(!isValid()) {
            throw new RuntimeException("Line Item invalid");
        }
        product.checkValidity();
    }

    private boolean isValid() {
        return quantity > 0 && listPrice  >= 0;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(double taxTotal) {
        this.taxTotal = taxTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public AProduct getProduct() {
        return product;
    }

    public void setProduct(AProduct product) {
        this.product = product;
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

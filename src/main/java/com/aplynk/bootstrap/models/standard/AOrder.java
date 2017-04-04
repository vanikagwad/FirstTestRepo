package com.aplynk.bootstrap.models.standard;

import com.aplynk.bootstrap.blueprints.JsonModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Soumya on 05-12-2016.
 */

public class AOrder extends JsonModel {

    private String id;

    private String number;

    private Double total;

    @SerializedName("sub_total")
    private Double subTotal;

    @SerializedName("tax_total")
    private Double taxTotal;

    @SerializedName("tax_percentage")
    private Double taxPercentage;

    @SerializedName("tax_code")
    private String taxCode;

    @SerializedName("discount_percentage")
    private Double discountPercentage;

    @SerializedName("discount_code")
    private String discountCode;

    private String date;

    @SerializedName("due_date")
    private String dueDate;

    @SerializedName("payment_terms")
    private String paymentTerms;

    @SerializedName("paymentTermsCode")
    private String payment_terms_code;

    @SerializedName("currency_code")
    private String currencyCode;

    @SerializedName("exchange_rate")
    private Double exchangeRate;

    @SerializedName("external_reference")
    private String externalReference;

    private AAccount account;

    private AAddress billingAddress;

    private AAddress shippingAddress;

    @SerializedName("line_items")
    private List<ALineItem> lineItems;

    public void checkValidity() {
        if(!isValid()) {
            throw new RuntimeException("Sales Order invalid");
        }

        account.checkValidity();

        for(ALineItem lineItem:lineItems) {
            lineItem.checkValidity();
        }
    }

    public AAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(AAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public AAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(AAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    private boolean isValid() {
        return id != null && id.length() > 0 && total != null;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(Double taxTotal) {
        this.taxTotal = taxTotal;
    }

    public Double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getPayment_terms_code() {
        return payment_terms_code;
    }

    public void setPayment_terms_code(String payment_terms_code) {
        this.payment_terms_code = payment_terms_code;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
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

    public List<ALineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<ALineItem> lineItems) {
        this.lineItems = lineItems;
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

package com.aplynk.bootstrap.models;

import com.aplynk.bootstrap.blueprints.JsonModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blaze on 10-05-2016.
 */
public class Invoice extends JsonModel{
	@SerializedName("customer_id")
	private String customerId;
	@SerializedName("customer_name")
	private String customerName;
	@SerializedName("date")
	private String date;
	@SerializedName("amount")
	private String amount;
	@SerializedName("line_items")
	private List<LineItem> lineItems = new ArrayList<>();

	public Invoice(String customerId, String customerName, String date, String amount) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.date = date;
		this.amount = amount;

		lineItems.add(new LineItem("1","1000","Big Rug"));
		lineItems.add(new LineItem("1","300","Small Rug"));
	}

	@Override
	public JsonObject toJson() {
		return getJson(this);
	}

	@Override
	public String toString() {
		return toJson().toString();
	}
}

package com.aplynk.bootstrap.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Blaze on 13-10-2016.
 */
public class LineItem {
	@SerializedName("quantity")
	String quantity;
	@SerializedName("amount")
	String amount;
	@SerializedName("product_name")
	String productName;

	public LineItem(String quantity, String amount, String productName) {
		this.quantity = quantity;
		this.amount = amount;
		this.productName = productName;
	}
}

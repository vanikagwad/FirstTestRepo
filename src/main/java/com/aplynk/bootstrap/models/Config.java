package com.aplynk.bootstrap.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Blaze on 10-05-2016.
 */
public class Config {
	@SerializedName("api_key")
	String apiKey;

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	@Override
	public String toString() {
		return "Config{" +
				"apiKey='" + apiKey + '\'' +
				'}';
	}
}

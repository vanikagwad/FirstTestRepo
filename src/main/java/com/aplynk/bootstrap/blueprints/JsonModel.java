package com.aplynk.bootstrap.blueprints;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Created by Blaze on 29-03-2016.
 */
public abstract class JsonModel {
	public JsonObject getJson(Object object) {
		return (JsonObject) new Gson().toJsonTree(object);
	}

	public abstract JsonObject toJson();
}

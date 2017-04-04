package com.aplynk.bootstrap.models;

import com.aplynk.bootstrap.blueprints.JsonModel;
import com.google.gson.JsonObject;

/**
 * Created by Blaze on 10-05-2016.
 */
public class MockTriggerOutput extends JsonModel{
	String name;
	String greeting;

	public MockTriggerOutput(String name, String greeting) {
		this.name = name;
		this.greeting = greeting;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public String toString() {
		return "MockActionInput{" +
				"name='" + name + '\'' +
				", greeting='" + greeting + '\'' +
				'}';
	}

	@Override
	public JsonObject toJson() {
		return getJson(this);
	}
}

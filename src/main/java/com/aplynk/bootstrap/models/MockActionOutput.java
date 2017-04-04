package com.aplynk.bootstrap.models;

import com.aplynk.bootstrap.blueprints.JsonModel;
import com.google.gson.JsonObject;

/**
 * Created by Blaze on 10-05-2016.
 */
public class MockActionOutput extends JsonModel{
	String greeting;
	String originalGreeting;

	public MockActionOutput(String greeting, String originalGreeting) {
		this.greeting = greeting;
		this.originalGreeting = originalGreeting;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getOriginalGreeting() {
		return originalGreeting;
	}

	public void setOriginalGreeting(String originalGreeting) {
		this.originalGreeting = originalGreeting;
	}

	@Override
	public String toString() {
		return "MockActionOutput{" +
				"greeting='" + greeting + '\'' +
				", originalGreeting='" + originalGreeting + '\'' +
				'}';
	}

	@Override
	public JsonObject toJson() {
		return getJson(this);
	}
}

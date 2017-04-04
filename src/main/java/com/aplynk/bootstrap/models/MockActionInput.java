package com.aplynk.bootstrap.models;

/**
 * Created by Blaze on 10-05-2016.
 */
public class MockActionInput {
	String name;
	String greeting;

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
}

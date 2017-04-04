package com.aplynk.bootstrap.blueprints;

import com.aplynk.bootstrap.models.Config;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.elastic.api.EventEmitter;
import io.elastic.api.ExecutionParameters;
import io.elastic.api.Message;
import io.elastic.api.Module;

import javax.json.Json;
import javax.json.JsonReader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by soumya on 02-05-2016.
 */
public abstract class BaseComponent implements Module {
    private EventEmitter eventEmitter;
    private Map<String, String> mockEnvvars = new HashMap<>();
	private boolean testing = false;
    private ExecutionParameters params;
    private Config config;

    @Override
    public void execute(ExecutionParameters parameters) {
        this.eventEmitter = parameters.getEventEmitter();
        this.params = parameters;
        this.config = new Gson().fromJson(parameters.getConfiguration().toString(), Config.class);
    }

    protected void emitData(JsonObject data) {
        String d = data.toString();
        JsonReader reader = Json.createReader(new StringReader(d));
        Message message = new Message.Builder().body(reader.readObject()).build();
        this.eventEmitter.emitData(message);
    }

    protected void emitError(Exception e) {
        eventEmitter.emitException(e);
    }

    public void emitError(String message) {
        emitError(new RuntimeException(message));
    }

	public void emitRebound(String reason) {eventEmitter.emitRebound(reason);}

	public void emitSnapshot(JsonObject data) {
        String d = data.toString();
        JsonReader reader = Json.createReader(new StringReader(d));
        eventEmitter.emitSnapshot(reader.readObject());
    }

	public void emitToken(JsonObject data) {
        String d = data.toString();
        JsonReader reader = Json.createReader(new StringReader(d));
		eventEmitter.emitUpdateKeys(reader.readObject());
	}

    protected void log(String message) {
        System.out.println("--- " + new Date()+ " --- | -----> " + message);
    }

    protected String getEnv(String key) {
		if(!testing) {
			return System.getenv(key);
		} else {
			return mockEnvvars.get(key);
		}
	}

	protected Config getConfig() {
        return config;
    }

    protected <T> T  getInput(Type tClass) {
        return new Gson().fromJson(params.getMessage().getBody().toString(), tClass);
    }

    protected <T> T  getSnapshot(Type tClass) {
        return new Gson().fromJson(params.getSnapshot().toString(), tClass);
    }

	public void addMockEnvVar(String key, String val) {
		testing = true;
		mockEnvvars.put(key, val);
	}
}

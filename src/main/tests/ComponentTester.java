import com.aplynk.bootstrap.blueprints.BaseComponent;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.elastic.api.EventEmitter;
import io.elastic.api.ExecutionParameters;
import io.elastic.api.Message;

import javax.json.Json;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Created by Blaze on 03-05-2016.
 */
public class ComponentTester {
	public static void main(String... args) {
		EventEmitter.Builder builder = new EventEmitter.Builder();
		builder.onData(data -> {
			System.out.println("---| Data Emitted |---");
			Message message = (Message) data;
			System.out.println(message.getBody().toString());
		});
		builder.onError(data -> {
            System.out.println("---| Error Emitted |---");
            Exception exception = (Exception) data;
            System.out.println(exception.getMessage());
        });
		builder.onRebound(data -> System.out.println("onRebound : " + data));
		builder.onSnapshot(data -> {
            System.out.println("---| Snapshot Emitted |---");
            System.out.println(data.toString());
        });
		builder.onUpdateKeys(data -> {
            System.out.println("Keys Updated");
            System.out.println(data.toString());
        });
		EventEmitter eventEmitter = builder.onHttpReplyCallback(data -> System.out.println("Http Reply: " + data)).build();

		try {
			BaseComponent component = (BaseComponent) Class.forName("com.aplynk.bootstrap.actions.MockAction").getDeclaredConstructor().newInstance();
//			BaseComponent component = (BaseComponent) Class.forName("com.aplynk.bootstrap.triggers.MockTrigger").getDeclaredConstructor().newInstance();

			String inputData = readFile("input.json", StandardCharsets.UTF_8);
			JsonReader reader = Json.createReader(new StringReader(inputData));
			Message message = new Message.Builder().body(reader.readObject()).build();
			ExecutionParameters.Builder paramBuilder = new ExecutionParameters.Builder(message, eventEmitter);

			String configData = readFile("config.json", StandardCharsets.UTF_8);
			reader = Json.createReader(new StringReader(configData));
			paramBuilder.configuration(reader.readObject());

			String snapshotData = readFile("snapshot.json", StandardCharsets.UTF_8);
			reader = Json.createReader(new StringReader(snapshotData));
			paramBuilder.snapshot(reader.readObject());

			ExecutionParameters params = paramBuilder.build();

			String envVarsData = readFile("env_vars.json", StandardCharsets.UTF_8);
			JsonObject envVars = new Gson().fromJson(envVarsData, JsonObject.class);
			for (Map.Entry<String, JsonElement> item:envVars.entrySet()) {
				component.addMockEnvVar(item.getKey(), item.getValue().getAsString());
			}

			component.execute(params);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | IOException e) {
			e.printStackTrace();
		}
	}

	private static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}

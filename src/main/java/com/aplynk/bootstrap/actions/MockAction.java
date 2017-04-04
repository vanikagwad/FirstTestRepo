package com.aplynk.bootstrap.actions;

import com.aplynk.bootstrap.blueprints.BaseComponent;
import com.aplynk.bootstrap.models.Config;
import com.aplynk.bootstrap.models.Invoice;
import io.elastic.api.ExecutionParameters;

public class MockAction extends BaseComponent {

	private Config config;
	private Invoice input;

	@Override
    public void execute(ExecutionParameters parameters) {
		super.execute(parameters);

		config = getConfig();
        input = getInput(Invoice.class);

		log("Logging CONFIG: " + config);
		log("Logging INPUT: " + input);
		log("Logging ENVVAR: " + getEnv("TEST_CLIENT_ID"));
		log("Logging SNAPSHOT: " + parameters.getSnapshot());
		emitData(input.toJson());
    }

	//TODO: do your work here
	/*private void processAction() {
		MockApi api = new RequestHelper().getBuilder().create(MockApi.class);
		api.getMockData(config.getApiKey()).subscribe(new Observer<MockActionOutput>() {
			@Override
			public void onCompleted() {
				log("Completed");
			}

			@Override
			public void onError(Throwable e) {
				log("Error");
				emitError(e.getMessage());
			}

			@Override
			public void onNext(MockActionOutput mockActionOutput) {
				log("Success");
				emitData(mockActionOutput.toJson());
			}
		});
	}*/
}

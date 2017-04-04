package com.aplynk.bootstrap.blueprints;

import com.aplynk.bootstrap.models.Config;
import com.aplynk.bootstrap.models.Invoice;
import io.elastic.api.ExecutionParameters;

public class StandardComponent extends BaseComponent {

	private Config config;
	private Invoice input;

	@Override
    public void execute(ExecutionParameters parameters) {
		super.execute(parameters);
		config = getConfig();
		input = getInput(Invoice.class);
    }
}

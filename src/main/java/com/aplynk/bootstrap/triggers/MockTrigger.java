package com.aplynk.bootstrap.triggers;

import com.aplynk.bootstrap.blueprints.BaseComponent;
import com.aplynk.bootstrap.models.Config;
import com.aplynk.bootstrap.models.Invoice;
import com.aplynk.bootstrap.models.MockActionInput;
import com.google.gson.Gson;
import io.elastic.api.ExecutionParameters;

public class MockTrigger extends BaseComponent {
    private Config config;
    private MockActionInput input;

    @Override
    public void execute(ExecutionParameters parameters) {
        super.execute(parameters);

        config = new Gson().fromJson(parameters.getConfiguration().toString(), Config.class);

        Invoice inv = new Invoice("123456", "Test Customer", "12-10-2016", "1300");
        emitData(inv.toJson());
    }
}

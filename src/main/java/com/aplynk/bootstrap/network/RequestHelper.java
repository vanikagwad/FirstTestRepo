package com.aplynk.bootstrap.network;

import retrofit.RestAdapter;

/**
 * Created by soumya on 19-04-2016.
 */
public class RequestHelper {
    //TODO: Change the base url when implementing
    private static final String BASE_URL = "http://www.mocky.io/v2/";

    public RestAdapter getBuilder() {
        RestAdapter.Builder builder = new RestAdapter.Builder();
        builder.setEndpoint(BASE_URL);
        builder.setLogLevel(RestAdapter.LogLevel.FULL);
        return builder.build();
    }
}

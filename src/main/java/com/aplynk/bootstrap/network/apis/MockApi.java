package com.aplynk.bootstrap.network.apis;

import com.aplynk.bootstrap.models.MockActionOutput;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Blaze on 10-05-2016.
 */
public interface MockApi {
	@GET("/{api_key}")
	Observable<MockActionOutput> getMockData(@Path("api_key") String api_key);
}

/*package com.just.demo;

import java.util.concurrent.TimeUnit;

import com.exclusively.model.ServiceRequest;
import com.exclusively.utils.Constants;
import com.exclusively.utils.MWebUtills;
import com.exclusively.utils.ServiceName;
import com.google.gson.JsonObject;

import rx.Observable;
import rx.schedulers.Schedulers;

public class RxJavaDemo {

	public static void main(String[] args) {
		Observable.timer(0L, 5L, TimeUnit.SECONDS, Schedulers.io()).map(s -> {
			try {
				JsonObject obj = new JsonObject();
				obj.add("key", "value");
				return webConfigService.callService(new ServiceRequest(ServiceName.CMS_BASE_URL.getServiceName(),
						ServiceName.CMS_FETCH_WEB_CONFIG.getServiceName(), null));
			} catch (Exception e) {
				LOGGER.error("Exception in webConfigService");
			}
			return null;
		}).map(s -> null != s ? MWebUtills.getJsonProperty(s.getServiceResponse(), "data") : null)
				.forEach(s -> System.out.println("***************** "+s+" *****************")observableMap.put(
						null != s ? MWebUtills.getJsonProperty(s.toString(), "key").toString() : "", null != s
								? MWebUtills.getJsonProperty(s.toString(), "value").toString() : ""));

	}

}
*/
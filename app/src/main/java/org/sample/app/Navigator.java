package org.sample.app;

public class Navigator {
	private RequestMap url;
	public Navigator(String msg) {
		url = new RequestMap(msg);
	}

	public String navigate() {
		NavConsumer consumer = new NavConsumer(url);
		DataRequest dataRequest = new DataRequest("user");
		consumer.accept(dataRequest);
		return dataRequest.query();
	}
}

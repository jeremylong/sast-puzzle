package org.sample.app;

import java.util.function.Consumer;

public class NavConsumer implements Consumer<DataRequest>  {

	RequestMap map;
	public NavConsumer(RequestMap url) {
		this.map = url;
	}

	@Override
	public void accept(DataRequest dataRequest) {
		dataRequest.addQuery(map.get("where"));
	}
}

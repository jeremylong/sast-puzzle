package org.sample.app;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class RequestMap {

	private Map<String, String> map;
	public RequestMap(String str) {
		String[] data = str.split("&");
		this.map = new HashMap<>();
		for (String s : data) {
			String[] temp = s.split("=");
			if (temp.length != 2)
				continue;
			//ensure casing is consistent
			if ("where".equalsIgnoreCase(temp[0])) {
				try {
					this.map.put("where", URLDecoder.decode(temp[1], "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					//ignore
				}
			} else if ("name".equalsIgnoreCase(temp[0])) {
				try {
					this.map.put("name", URLDecoder.decode(temp[1], "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					//ignore
				}
			} else {
				try {
					this.map.put(URLDecoder.decode(temp[0], "UTF-8"), URLDecoder.decode(temp[1], "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					//ignore
				}
			}
		}
	}

	public String get(String key) {
		return map.get(key);
	}

}

package org.sample.app;

import javax.servlet.http.HttpServletRequest;

public class Action {
	HttpServletRequest fRequest;
	public Action(HttpServletRequest fRequest) {
		this.fRequest = fRequest;
	}

	private String execute() {
		Navigator nav = new Navigator(fRequest.getQueryString());
		return nav.navigate();
	}
}

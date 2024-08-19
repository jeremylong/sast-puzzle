package org.sample.app;

public class QueryExecutor {
	private Query query;

	public QueryExecutor(Query query) {
		this.query = query;
	}

	public String execute(DBOperation dbi) {
		return dbi.execute(query);
	}
}

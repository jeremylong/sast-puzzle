package org.sample.app;

public class DataRequest {

	private Query internalQuery;

	public DataRequest() {}
	public DataRequest(String table) {
		this.internalQuery = new Query(table);
	}

	public void addQuery(String query) {
		this.internalQuery.addWhereClause(query);
	}

	public String query() {
		DBOperation dbi = new DBOperation();
		QueryExecutor executor = new QueryExecutor(internalQuery);
		return executor.execute(dbi);
	}

}

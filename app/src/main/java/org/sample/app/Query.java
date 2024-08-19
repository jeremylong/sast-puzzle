package org.sample.app;

public class Query {
	private String name;
	private String where;
	public Query(String name) {
		this.name = name;
	}

	public void addWhereClause(String where) {
		this.where = where;
	}

	public String toSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM ");
		sb.append(name);
		sb.append(" WHERE ");
		sb.append(where);
		return sb.toString();
	}
}

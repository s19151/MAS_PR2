package io.github.s19151.model.projection;

public enum ClientType {
	ClientPerson(0), ClientCompany(1);
	
	private int val;
	
	private ClientType(int val) {
		this.val = val;
	}
	
	public int getVal() {
		return val;
	}
}

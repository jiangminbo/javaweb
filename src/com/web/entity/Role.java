package com.web.entity;

import java.io.Serializable;

public class Role implements Serializable{

	
	private int rid;
	
	private String name;

	
	public Role() {}

	public Role(int rid, String name) {
		this.rid = rid;
		this.name = name;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

package com.ananya.bean;

import java.io.InputStream;

public class AdminBean {
	 
	private int admin_id;
	 private String name;
	 private String password;
	 
	 
	 public AdminBean() {
		 
	 }
	public AdminBean(int admin_id, String name, String password) {
		super();
		this.admin_id = admin_id;
		this.name = name;
		this.password = password;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminBean [admin_id=" + admin_id + ", name=" + name + ", password=" + password + "]";
	}
	  

}

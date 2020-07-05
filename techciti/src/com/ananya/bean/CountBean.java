package com.ananya.bean;

public class CountBean {
	
	private int count_id;
	private int user_id;
	private String ip_address;
	private int count;
	public CountBean(int count_id, int user_id, String ip_address, int count) {
		super();
		this.count_id = count_id;
		this.user_id = user_id;
		this.ip_address = ip_address;
		this.count = count;
	}
	public CountBean() {
		
	}
	public int getCount_id() {
		return count_id;
	}
	public void setCount_id(int count_id) {
		this.count_id = count_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int access_id) {
		this.user_id = access_id;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ipAddress) {
		this.ip_address = ipAddress;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CountBean [count_id=" + count_id + ", user_id=" +user_id + ", ip_address=" + ip_address
				+ ", count=" + count + "]";
	}
	
}

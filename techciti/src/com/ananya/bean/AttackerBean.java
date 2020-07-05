package com.ananya.bean;

import java.io.InputStream;
import java.util.Date;

public class AttackerBean {
private int access_id;
private int user_id;
private String attack_time;
private InputStream share_file;
private String file_path;
private String ip_address;
private String  block_status;
public AttackerBean() {
	
}


public String getBlock_status() {
	return block_status;
}


public void setBlock_status(String block_status) {
	this.block_status = block_status;
}


public AttackerBean(int access_id, int user_id, String attack_time, InputStream share_file, String file_path,
		String ip_address, String block_status) {
	super();
	this.access_id = access_id;
	this.user_id = user_id;
	this.attack_time = attack_time;
	this.share_file = share_file;
	this.file_path = file_path;
	this.ip_address = ip_address;
	this.block_status = block_status;
}

public int getAccess_id() {
	return access_id;
}

public void setAccess_id(int access_id) {
	this.access_id = access_id;
}

public int getUser_id() {
	return user_id;
}

public void setUser_id(int user_id) {
	this.user_id = user_id;
}

public String getAttack_time() {
	return attack_time;
}

public void setAttack_time(String strDate) {
	this.attack_time = strDate;
}

public InputStream getShare_file() {
	return share_file;
}

public void setShare_file(InputStream share_file) {
	this.share_file = share_file;
}

public String getFile_path() {
	return file_path;
}

public void setFile_path(String file_path) {
	this.file_path = file_path;
}

public String getIp_address() {
	return ip_address;
}

public void setIp_address(String ipAddress) {
	this.ip_address = ipAddress;
}

@Override
public String toString() {
	return "AttackerBean [access_id=" + access_id + ", user_id=" + user_id + ", attack_time=" + attack_time
			+ ", share_file=" + share_file + ", file_path=" + file_path + ", ip_address=" + ip_address + "]";
}

}

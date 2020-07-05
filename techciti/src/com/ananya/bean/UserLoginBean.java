package com.ananya.bean;

import java.util.Date;

public class UserLoginBean { 
private String name;
private String	access_time;
private String	login_status;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getAccess_time() {
	return access_time;
}
public void setAccess_time(String access_time) {
	this.access_time = access_time;
}
public String getLogin_status() {
	return login_status;
}
public void setLogin_status(String login_status) {
	this.login_status = login_status;
}

public UserLoginBean(String name, String access_time, String login_status) {
	super();
	this.name = name;
	this.access_time = access_time;
	this.login_status = login_status;
}
public UserLoginBean() {
	
}

 

}
package com.ananya.bean;

import java.io.InputStream;

public class FileShareBean {
	private int user_id;
	private int share_id;
	 private String share_member_name;
	 private String file_title;
	 private InputStream share_file;
	 private String file_path;
	 
	 public FileShareBean() {
		 
	 }
	 
	 
	



	public FileShareBean(int user_id, int share_id, String share_member_name, String file_title, InputStream share_file,
			String file_path) {
		super();
		this.user_id = user_id;
		this.share_id = share_id;
		this.share_member_name = share_member_name;
		this.file_title = file_title;
		this.share_file = share_file;
		this.file_path = file_path;
	}






	public String getFile_path() {
		return file_path;
	}






	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}






	public int getShare_id() {
		return share_id;
	}



	public void setShare_id(int share_id) {
		this.share_id = share_id;
	}



	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getShare_member_name() {
		return share_member_name;
	}
	public void setShare_member_name(String share_member_name) {
		this.share_member_name = share_member_name;
	}
	public String getFile_title() {
		return file_title;
	}
	public void setFile_title(String file_title) {
		this.file_title = file_title;
	}
	public InputStream getShare_file() {
		return share_file;
	}
	public void setShare_file(InputStream share_file) {
		this.share_file = share_file;
	}
	 
}

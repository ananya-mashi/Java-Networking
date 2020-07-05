package com.ananya.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ananya.bean.AttackerBean;
import com.ananya.bean.RegisterBean;
import com.ananya.dao.AttackerDao;
import com.ananya.dao.RegisterDao;

public class BlockedUserServlet  extends HttpServlet{
	public BlockedUserServlet() {
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Ip_Address=request.getParameter("Ip_Address");
AttackerBean bean = new AttackerBean ();
AttackerDao dao = new AttackerDao();
bean.setIp_address(Ip_Address);
bean.setBlock_status("Blocked");
dao.SetBlockedIpAddress(bean);
}
}
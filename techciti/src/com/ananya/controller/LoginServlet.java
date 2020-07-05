package com.ananya.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.ananya.bean.AttackerBean;
import com.ananya.bean.RegisterBean;
import com.ananya.bean.UserLoginBean;
import com.ananya.dao.AttackerDao;
import com.ananya.dao.RegisterDao;
@MultipartConfig 
public class LoginServlet extends HttpServlet {
	public LoginServlet() {
		
	}
	 InputStream inputStream;
	 HttpSession session;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RegisterBean registerBean = new RegisterBean();
		 UserLoginBean uloginbean =new UserLoginBean();
		 
		 
		String name = request.getParameter("name");
		String password = request.getParameter("password");

	    Part filePart = request.getPart("image");
		 
		 AttackerBean bean = new AttackerBean ();
		
		 AttackerDao dao = new AttackerDao();
		 String ip=getClientIpAddress(request);
		
		String block=dao.getBlock_status(ip);
		
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getSubmittedFileName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

         inputStream = filePart.getInputStream();
        }
		 registerBean.setName(name);
		 uloginbean.setName(name);
	 HttpSession session = request.getSession();
		 session.setAttribute("ip_address",ip);
	        Date creationTime = new Date(session.getCreationTime() );
	     
	        SimpleDateFormat formatter; 
	        String strDate ;
	        formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");  
	        strDate = formatter.format(creationTime);  
		uloginbean.setAccess_time( strDate);
		
         registerBean.setPassword(password); 
         registerBean.setImage( inputStream);
        RegisterDao registerDao = new RegisterDao();
       int id= registerDao.loginUser(registerBean);
      
       
     System.out.print(id);
    
        if(id==0||block!=null)    {
        	
        	 uloginbean.setLogin_status("Fail");
        	 registerDao .saveLoginInfo(uloginbean);
        	 request.getRequestDispatcher("/Userlogin.jsp").forward(request, response);
           }
        else   
        {
       	 uloginbean.setLogin_status("Success");
       	 registerDao .saveLoginInfo(uloginbean);
       	 session.setAttribute("id", id);
        
        	 request.getRequestDispatcher("/FileShare.jsp").forward(request, response);
             
        }
		
    }

private static final String[] HEADERS_TO_TRY = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR" };

private String getClientIpAddress(HttpServletRequest request) {
    for (String header : HEADERS_TO_TRY) {
        String ip = request.getHeader(header);
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
    }

    return request.getRemoteAddr();
}

}

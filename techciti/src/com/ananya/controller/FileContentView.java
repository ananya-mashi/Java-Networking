package com.ananya.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.ananya.bean.AttackerBean;
import com.ananya.bean.CountBean;
import com.ananya.bean.FileShareBean;
import com.ananya.dao.AttackerDao;
import com.ananya.dao.FileUploadDao;

public class FileContentView extends HttpServlet{
	public FileContentView(){
	}


	 	CountBean cbean=new CountBean();
	FileShareBean filebean=new FileShareBean();
	AttackerBean attackerbean=new AttackerBean();
   FileUploadDao filedao= new FileUploadDao();  
   AttackerDao attackerDao =new AttackerDao();

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	   	 HttpSession session=request.getSession();
	    
	    	int id= (int) session.getAttribute("user_id");
			
	      
	  
	    	String s=(String) request.getParameter("textArea");
	    	System.out.println(s);
	    	 Pattern p= Pattern.compile ("[@#$%&*()_+=|<>{}\\[\\]~-]");
	    	// Pattern p = Pattern.compile("[^A-Za-z0-9]");
	         Matcher m = p.matcher(s);
	  	      boolean b1 = m.find();
	  // System.out.println(b);
	   System.out.println(b1);
	   
	  
	
	
	 
	   
	if(b1) {
		 
		   Date creationTime = new Date(session.getCreationTime() );
		     
	       SimpleDateFormat formatter; 
	       String strDate ;
	       formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");  
	       strDate = formatter.format(creationTime);  
		attackerbean.setAttack_time( strDate );
		   attackerbean.setFile_path( (String) session.getAttribute("file_path"));
		   String ipAddress =  (String) session.getAttribute("ip_address");
		attackerbean.setIp_address(ipAddress);
		Part filePart= (Part) session.getAttribute("share_file");

		InputStream  inputStream = filePart.getInputStream();
		
		attackerbean.setShare_file(inputStream);
        attackerbean.setUser_id((int) session.getAttribute("id"));
		   
		attackerDao.saveAttacker(attackerbean);
		   
		  
		   int count =  attackerDao.getCount(ipAddress);
		
		   cbean.setCount(count);
		   System.out.println(cbean.getCount());
		   cbean.setIp_address(ipAddress);
	
		   cbean.setUser_id(id);
		attackerDao.saveOrUpdateCount(cbean);
		request.getRequestDispatcher("ErrorFile.jsp").forward(request, response);
		
	}
	else {
		filebean.setFile_path(  (String) session.getAttribute("file_path"));
		Part filePart= (Part) session.getAttribute("share_file");

		InputStream  inputStream = filePart.getInputStream();
        filebean.setShare_file(inputStream);
      filebean.setUser_id(id);
     
		 filedao.saveFile(filebean);
		    int share_id =  filedao.getId(filebean);
	          System.out.println(share_id);
	       session.setAttribute("share_id", share_id);
	      
		 request.getRequestDispatcher("FileSharing.jsp").forward(request, response);
	}
}



}

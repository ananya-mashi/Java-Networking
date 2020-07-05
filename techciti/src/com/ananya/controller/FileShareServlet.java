package com.ananya.controller;

import java.awt.Window;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ananya.bean.FileShareBean;
import com.ananya.dao.FileUploadDao;


public class FileShareServlet extends HttpServlet {
	
	public FileShareServlet() {
		
	}
	
	HttpSession session;
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 HttpSession session=request.getSession();
			   
    		int id=(int)session.getAttribute("share_id");
			String title = request.getParameter("title");
	         String receiver = request.getParameter("user");
	         System.out.println(title);
	         
	         System.out.println(receiver);
	         
	      
	         FileUploadDao dao= new FileUploadDao();        
   FileShareBean bean=new FileShareBean();
         
         bean.setShare_id(id);
	         bean.setFile_title(title);
	       bean.setShare_member_name(receiver);
	       dao.saveData(bean);
	     
	       	request.setAttribute("msg",true);

	        request.getRequestDispatcher("Info File.jsp").forward(request, response);
	      
	         }

}

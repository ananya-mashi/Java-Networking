package com.ananya.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.ananya.bean.AdminBean;
import com.ananya.bean.RegisterBean;
import com.ananya.dao.AdminDao;
import com.ananya.dao.RegisterDao;
@MultipartConfig 
public class AdminLoginServlet extends HttpServlet {
	public AdminLoginServlet() {
		
	}
	 InputStream inputStream;
	 HttpSession session;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminBean adminBean = new AdminBean();
		String name = request.getParameter("name");
		String password = request.getParameter("password");

	
       
    
		adminBean.setName(name);
 
         adminBean.setPassword(password); 
        
      AdminDao    adminDao = new    AdminDao ();
       int id= adminDao.loginAdmin(adminBean);
       HttpSession session=request.getSession();
       
     System.out.print(id);
    
        if(id==0)    {
        	 request.getRequestDispatcher("/Adminlogin.jsp").forward(request, response);
           }
        else   
        { session.setAttribute("id", id);
           
        	 request.getRequestDispatcher("/AttackerDetails.jsp").forward(request, response);
             
        }
    }
 

}

package com.ananya.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ananya.bean.RegisterBean;
import com.ananya.dao.RegisterDao;

@MultipartConfig  
public class RegisterServlet extends HttpServlet {
 

    public RegisterServlet() {
    }
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	    InputStream inputStream = null;
         String name = request.getParameter("name");
         String email = request.getParameter("email");
         Part filePart = request.getPart("image");
         String password = request.getParameter("password");
         if (filePart != null) {
             // prints out some information for debugging
             System.out.println(filePart.getSubmittedFileName());
             System.out.println(filePart.getSize());
             System.out.println(filePart.getContentType());

             // obtains input stream of the upload file
             inputStream = filePart.getInputStream();
         }
         RegisterBean registerBean = new RegisterBean();
      
         registerBean.setName(name);
         registerBean.setEmail(email);
         registerBean.setImage( inputStream);
         registerBean.setPassword(password); 
         
         RegisterDao registerDao = new RegisterDao();
        String userRegistered = registerDao.registerUser(registerBean);
         
         if(userRegistered.equals("SUCCESS"))    {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
         }
         else   
         {
            
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
         }
     }
}
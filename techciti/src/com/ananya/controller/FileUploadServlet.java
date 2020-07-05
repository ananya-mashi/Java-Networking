package com.ananya.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.ananya.bean.FileShareBean;
import com.ananya.dao.FileUploadDao;





@MultipartConfig
public class FileUploadServlet extends HttpServlet {

public FileUploadServlet(){
}

   

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       HttpSession session=request.getSession();
   
    	int id=(int) (session.getAttribute("id"));
        InputStream inputStream = null; 
     FileUploadDao dao= new FileUploadDao();
        FileShareBean bean=new FileShareBean();
    
        Part filePart = request.getPart("file");
        if (filePart != null) {
        	   
            
            String name=Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            System.out.println(name);
            
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

                    
            
            inputStream = filePart.getInputStream();
            Scanner s = new Scanner(inputStream).useDelimiter("\\A");
            String result = s.hasNext() ? s.next() : "";
              
                session.setAttribute("text",result);
            
         
            session.setAttribute("file_path",filePart.getSubmittedFileName());
            session.setAttribute("share_file",filePart);
            session.setAttribute("user_id",id);
          session.setAttribute("file_name",name);
         
        }
     
             
          
        request.getRequestDispatcher("FileView.jsp").forward(request, response);
        }
    }
    


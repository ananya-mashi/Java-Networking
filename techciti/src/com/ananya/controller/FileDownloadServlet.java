package com.ananya.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ananya.bean.FileShareBean;
import com.ananya.dao.FileUploadDao;
import com.ananya.db.DBConnection;

public class FileDownloadServlet extends HttpServlet {
	
public FileDownloadServlet() {
	
}
private static final int BUFFER_SIZE = 4096; 

protected void doGet(HttpServletRequest request,HttpServletResponse response) 
		throws ServletException, IOException {
	InputStream inputStream;

int share_id=Integer.parseInt(request.getParameter("share_id"));
 
	Connection con = null; 

	PreparedStatement preparedStatement = null;  
  try
    {
    	 con = DBConnection.createConnection();
        
	    String sql = "SELECT * FROM file_share WHERE share_id = ?";
	    PreparedStatement statement = con.prepareStatement(sql);
	 
		statement.setInt(1, share_id);

	    ResultSet result = statement.executeQuery();
	    if (result.next()) {
	        
	        String fileName = result.getString("file_title");
	        Blob blob = result.getBlob("share_file");
	      inputStream = blob.getBinaryStream();
	      	int fileLength = inputStream.available();
         
       
        ServletContext context =getServletContext();
        String mimeType = context.getMimeType(fileName);
        if (mimeType == null) {        
            mimeType = "application/octet-stream";
        }  
	    
         response.setContentType(mimeType);
        response.setContentLength(fileLength);
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", fileName);
        response.setHeader(headerKey, headerValue);

        // writes the file to the client
        OutputStream outStream = response.getOutputStream();
         
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
         
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
         
        inputStream.close();
        outStream.close();             
    } else {
        // no file found
        response.getWriter().print("File not found ");  
    }
         
    }catch (SQLException ex) {
        ex.printStackTrace();
        response.getWriter().print("SQL Error: " + ex.getMessage());
    } catch (IOException ex) {
        ex.printStackTrace();
        response.getWriter().print("IO Error: " + ex.getMessage());
    } finally {
        if (con != null) {
            // closes the database connection
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }          
    }
}
}


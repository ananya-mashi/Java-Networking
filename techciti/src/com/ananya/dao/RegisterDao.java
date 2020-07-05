package com.ananya.dao;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.sql.rowset.serial.SerialBlob;

import com.ananya.bean.RegisterBean;
import com.ananya.bean.UserLoginBean;
import com.ananya.db.DBConnection;


public class RegisterDao { 
    public String registerUser(RegisterBean registerBean)
    {
        String name = registerBean.getName();
        String email = registerBean.getEmail();
        InputStream image = registerBean.getImage();
        String password = registerBean.getPassword();
        
        Connection con = null;
        PreparedStatement preparedStatement = null;         
        try
        {
            con = DBConnection.createConnection();
            String query = "insert into registration(reg_id,name,email,image,password) values (NULL,?,?,?,?)"; 
            preparedStatement = con.prepareStatement(query); 
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setBlob(3,image);
            preparedStatement.setString(4, password);
            
            int i= preparedStatement.executeUpdate();
            
            if (i!=0)  return "SUCCESS"; 
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }       
        return "Oops.. Something went wrong there..!"; 
        }

	public int loginUser(RegisterBean registerBean) {
		 String name1 = registerBean.getName();
	   
	        String password1 = registerBean.getPassword();
	        InputStream image1 = registerBean.getImage();
	        String dbname,dbpass;
	        int dbid;
	       Blob dbimage;InputStream isimage;   
		  Connection con = null;
	        PreparedStatement preparedStatement = null;         
	        try
	        {
	            con = DBConnection.createConnection();
	            String query = "SELECT * FROM registration r WHERE r.name=? and r.password=? and r.image=? ";
	            preparedStatement = con.prepareStatement(query); 
	           preparedStatement.setString(1,name1);
	           preparedStatement.setString(2, password1);
	           preparedStatement.setBlob(3, image1);
	            System.out.println (  preparedStatement );
	            System.out.println(name1);
	            System.out.println(password1);
	            System.out.println(image1);
	            ResultSet rs =  preparedStatement.executeQuery();
	            System.out.println(rs);
	          if(rs.next()) {
	            	 dbname=rs.getString("name");
	            dbpass=rs.getString("password");
	            dbimage= rs.getBlob("image");
	            dbid=rs.getInt("reg_id");
	       InputStream in = dbimage.getBinaryStream();
	            System.out.println(dbname);
	            System.out.println(dbpass);
	            System.out.println(dbid);
	            	if(name1.equals(dbname)&& password1.equals(dbpass)) {
	            		return dbid; 
	            	}
	            }
	            
	}
	        catch(SQLException e)
	        {
	           e.printStackTrace();
	        }       
	      return 0; 
	        }

	public void saveLoginInfo(UserLoginBean uloginbean) {
		 String name = uloginbean.getName();
	String time=	 uloginbean.getAccess_time();
	String status=	 uloginbean.getLogin_status();
	        
	        Connection con = null;
	        PreparedStatement preparedStatement = null;         
	        try
	        {
	            con = DBConnection.createConnection();
	            String query = "insert into logininfo(login_id,name,Access_time,login_status) values (NULL,?,?,?)"; 
	            preparedStatement = con.prepareStatement(query); 
	            preparedStatement.setString(1, name);
	            preparedStatement.setString(2, time);
	          
	            preparedStatement.setString(3,status);
	            
	            int i= preparedStatement.executeUpdate();
	            
	         
	        }
	        catch(SQLException e)
	        {
	           e.printStackTrace();
	        }  
	        
	}

	public void deleteUser(int user_id) {
		 Connection con = null;
	        PreparedStatement preparedStatement = null;         
	        try
	        {
	            con = DBConnection.createConnection();
	            String query = "delete from registration where reg_id=?";
	            preparedStatement = con.prepareStatement(query); 
	            preparedStatement.setInt(1, user_id);
	         preparedStatement.executeUpdate();
	}   
    catch(SQLException e)
    {
       e.printStackTrace();
    } 
	}
}
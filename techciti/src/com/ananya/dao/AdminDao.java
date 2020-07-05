package com.ananya.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ananya.bean.AdminBean;
import com.ananya.bean.RegisterBean;
import com.ananya.db.DBConnection;

public class AdminDao {

	public int loginAdmin(AdminBean adminBean) {
		 String name = adminBean.getName();
	   
	        String password1 = adminBean.getPassword();
	  
	        String dbname,dbpass;
	        int dbid;
	      
		  Connection con = null;
	        PreparedStatement preparedStatement = null;         
	        try
	        {
	            con = DBConnection.createConnection();
	            String query = "SELECT * FROM admin a WHERE a.admin_name=? and a.password=?";
	            preparedStatement = con.prepareStatement(query); 
	           preparedStatement.setString(1,name);
	           preparedStatement.setString(2, password1);
	        
	            System.out.println (  preparedStatement );
	        
	            ResultSet rs =  preparedStatement.executeQuery();
	            System.out.println(rs);
	          if(rs.next()) {
	            	 dbname=rs.getString("admin_name");
	            dbpass=rs.getString("password");
	          
	            dbid=rs.getInt("admin_id");
	       
	            	if(name.equals(dbname)&& password1.equals(dbpass)) {
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

}

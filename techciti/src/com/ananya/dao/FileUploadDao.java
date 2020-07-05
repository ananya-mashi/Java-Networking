package com.ananya.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ananya.bean.FileShareBean;

import com.ananya.db.DBConnection;

public class FileUploadDao {

	public void saveFile(FileShareBean bean) {
		 InputStream file = bean.getShare_file();
	        int user_id=bean.getUser_id();
	        String path=bean.getFile_path();
	        Connection con = null;
	        PreparedStatement preparedStatement = null;         
	        try
	        {
	            con = DBConnection.createConnection();
	            String query = "insert into file_share(share_id,user_id,share_file,file_path) values (NULL,?,?,?)"; 
	            preparedStatement = con.prepareStatement(query); 
	            preparedStatement.setInt(1,user_id);
	           preparedStatement.setBlob(2,file);
	           preparedStatement.setString(3,path);
	            int i= preparedStatement.executeUpdate();
	            
	        }
	        catch(SQLException e)
	        {
	           e.printStackTrace();
	        }       
	}



	public void saveData(FileShareBean bean) {
	String title=	bean.getFile_title();
		String receiver=bean.getShare_member_name();
		int id=bean.getShare_id();
		 Connection con = null;
	        PreparedStatement preparedStatement = null;         
	        try
	        {
	            con = DBConnection.createConnection();
	            String query = "update file_share set file_title=?, share_member_name=? where share_id=?";
	            	
	            preparedStatement = con.prepareStatement(query); 
	            preparedStatement.setString(1,title);
	           preparedStatement.setString(2,receiver);
	           preparedStatement.setInt(3,id);
	            
	            int i= preparedStatement.executeUpdate();
	            
	        }
	        catch(SQLException e)
	        {
	           e.printStackTrace();
	        }  
	}

	public void deleteFile(FileShareBean bean) {
		int id=bean.getShare_id();
			 Connection con = null;
		        PreparedStatement preparedStatement = null;         
		        try
		        {
		            con = DBConnection.createConnection();
		            String query = "delete from file_share  where share_id=?";
		            	
		            preparedStatement = con.prepareStatement(query); 
		            preparedStatement.setInt(1,id);
		            
		            int i= preparedStatement.executeUpdate();
		            
		        }
		        catch(SQLException e)
		        {
		           e.printStackTrace();
		        }  
		}

	public int getId(FileShareBean bean) {
		 Connection con = null;
		String path=bean.getFile_path();
	        int user_id=bean.getUser_id();
	        int dbid;
	        PreparedStatement preparedStatement = null;         
	        try
	        {
	        	 con = DBConnection.createConnection();
		            String query = "select share_id from file_share where user_id=? and file_path=?";
		            
		            preparedStatement = con.prepareStatement(query); 
		            preparedStatement.setInt(1,user_id);
		            preparedStatement.setString(2,path);

		           ResultSet rs =  preparedStatement.executeQuery();
		          
		         while(rs.next()) {
		            
		            dbid=rs.getInt("share_id");     
		          
		          return dbid;
		          }
	        } catch(SQLException e)
	        {
		           e.printStackTrace();
		        }
		
		
		return 0;
	}


}

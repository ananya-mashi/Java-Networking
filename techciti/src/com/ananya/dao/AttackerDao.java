package com.ananya.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ananya.bean.AttackerBean;
import com.ananya.bean.CountBean;
import com.ananya.db.DBConnection;

public class AttackerDao {

	public void saveAttacker(AttackerBean attackerbean) {
		String time=attackerbean.getAttack_time();
		   String path=attackerbean.getFile_path();
		String ipAddress=attackerbean.getIp_address();
		 InputStream file = attackerbean.getShare_file();
		   int user_id=attackerbean.getUser_id();
		 
	        Connection con = null;
	        PreparedStatement preparedStatement = null;         
	        try
	        {
	            con = DBConnection.createConnection();
	            String query = "insert into attacker(access_id,user_id,Attack_time,Ip_Address,share_file,file_path) values (NULL,?,?,?,?,?)"; 
	            preparedStatement = con.prepareStatement(query); 
	            preparedStatement.setInt(1,user_id);
	            preparedStatement.setString(2,time);
		           preparedStatement.setString(3,ipAddress);
	           preparedStatement.setBlob(4,file);
	           preparedStatement.setString(5,path);
	            int i= preparedStatement.executeUpdate();
	            
	        }
	        catch(SQLException e)
	        {
	           e.printStackTrace();
	        }       
	}





	public int getCount(String ipAddress) {
		Connection con = null;
		
	        PreparedStatement preparedStatement = null;         
	        try
	        {
	        	 con = DBConnection.createConnection();
		            String query = "select c.count from techciti.count c where c.Ip_Address=?";
		            
		            preparedStatement = con.prepareStatement(query); 
		            preparedStatement.setString(1,ipAddress);
		          ResultSet rs =  preparedStatement.executeQuery();
		          
		         while(rs.next()) {
		            
		          int c=rs.getInt("count");     
		          
		          return c;
		          }
	        } catch(SQLException e)
	        {
		           e.printStackTrace();
		        }
		
		
		return 0;
	}


	public void saveOrUpdateCount(CountBean cbean) {
		int c=cbean.getCount();
		String ipAddress=cbean.getIp_address();
		int user_id=cbean.getUser_id();
	System.out.println(""+c+""+ipAddress);
		Connection con = null;
        PreparedStatement preparedStatement = null;         
        try
        {
            con = DBConnection.createConnection();
            
        	if(c==0) {
        		c=1;
            String query = "insert into techciti.count(count_id,user_id,Ip_Address,count) values (NULL,?,?,?)"; 
         
            preparedStatement = con.prepareStatement(query); 
            preparedStatement.setInt(1,user_id);
         
	           preparedStatement.setString(2,ipAddress);
	           preparedStatement.setInt(3,c);
	           preparedStatement.executeUpdate();
        	}
        	else {
        		c=c+1;
        		String query = "update techciti.count c set c.count=? where c.Ip_Address=?";
            	
	            preparedStatement = con.prepareStatement(query); 
		           preparedStatement.setInt(1,c);
	           
	            
		           preparedStatement.setString(2,ipAddress);
		       
		           preparedStatement.executeUpdate();
        	}
      
            
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }       
}





	public void SetBlockedIpAddress(AttackerBean bean) {
	String ip=	bean.getIp_address();
		String block=bean.getBlock_status();
		Connection con = null;
		
        PreparedStatement preparedStatement = null;         
        try
        {
        	 con = DBConnection.createConnection();
        	 String query = "update attacker set block_status=? where Ip_Address=?";
         	
	            preparedStatement = con.prepareStatement(query); 
	            preparedStatement.setString(1,block);
	           preparedStatement.setString(2,ip);
	         
	            
	           preparedStatement.executeUpdate();
	            
        }catch(SQLException e)
        {
            e.printStackTrace();
         } 
		
	}





	public String getBlock_status(String ip) {
		Connection con = null;
		String status;
        PreparedStatement preparedStatement = null;         
        try
        {
        	 con = DBConnection.createConnection();
             String query = "select block_status from attacker where Ip_Address=?";
	            
	            preparedStatement = con.prepareStatement(query); 
	            preparedStatement.setString(1,ip);
	           

	           ResultSet rs =  preparedStatement.executeQuery();
	          
	         while(rs.next()) {
	            
	        	 status=rs.getString("block_status");     
	          
	          return  status;
	          } 
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        } 
        return null;
	}}
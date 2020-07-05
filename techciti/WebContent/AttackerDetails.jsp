<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.ananya.db.DBConnection"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>
<head>
<meta name="viewport" content= "width=device-width, initial-scale=1.0"> 


 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  
<link href='https://fonts.googleapis.com/css?family=Alike' rel='stylesheet'>
	<title>
		title
	</title>
<style>
.cont{margin:5% 15% 0% 10%;background-color:white;
}
@media screen and (max-width:800px) {
	div.cont{
		margin-right:0%;
	}
	}
body{
		background-color: black;
	}

.headbtn{
	font-family: Alike;font-size: 1.4em; margin:5% 2% 5% 3%;
	}
	.table{
	font-size: 1.4em;
}
</style>
<body>
	<div class="cont">
	<div class="row">
	<div class="col">
	<a href="AttackerDetails.jsp" class="btn btn-dark headbtn" >ATTACKER DETAIL</a></div>
<div class="col">	<a href="LoginReport.jsp" class="btn btn-dark headbtn">LOGIN REPORT</a></div>
	<div class="col"><a href="RepeatedAttacker.jsp" class="btn btn-dark headbtn" >REPEATED ATTACKER</a></div>
<div class="col">	<a href="Graph.jsp" class="btn btn-dark headbtn">GRAPH</a></div>
  <c:url var="logout" value="/LogoutServlet"></c:url>
<div class="col">	<a href="${logout}" class="btn btn-dark headbtn">LOGOUT</a></div>
</div>
</div>
<br><br>
   <table class="table" style="margin:0% 5% 10% 10%; width:75%;">
    <thead style="color: white;background:#0d98ba ;">
      <tr>
        <th>IP Address</th>
        <th>Time To Attack</th>
        <th>Unwanted File</th>
        <th>No Of Time To Attack</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody style="background:white;">

	<%
	try{
Connection	con = DBConnection.createConnection();
String sql1 ="select distinct c.Ip_Address,a.share_file,a.user_id,a.Attack_time,a.block_status,c.count from techciti.attacker a INNER JOIN techciti.count c on a.Ip_Address=c.Ip_Address order by c.count_id desc;";
Statement s=con.createStatement();
ResultSet resultSet = s.executeQuery(sql1);
%>

      <%  while(resultSet.next()){ 
    
    	  
    	      String str=resultSet.getString("Ip_Address");%>
    	      <c:url var="block" value="/BlockedUserServlet">
    							<c:param name="Ip_Address" value="<%=str.toString()%>" />
    							
    						</c:url>
    						<tr>
     
        <td>      <%=resultSet.getString("Ip_Address") %></td>
        <td>      <%=resultSet.getString("Attack_time")%></td>
      
        <td>  <textarea rows="5" cols="40"  >   <%=resultSet.getString("share_file") %></textarea></td>
             <td>      <%=resultSet.getInt("count") %></td>
             <% 
             String block=resultSet.getString("block_status");
             if(block!=null){%>
             <td style="color:red;">Blocked</td><%} else{%>
 
   <td><a href="${block}" style="color:green;"><b>Block</b></a></td>
    <%} %>
    </tr><%} %>
  </tbody>
</table>
<br>
<br>

<br>
	<%

        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>
</body>
</html>
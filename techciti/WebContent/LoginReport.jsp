<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.ananya.db.DBConnection"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<div class="cont" style="">
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
        <th>Authentication Name</th>
        <th>Access Time</th>
        <th>Status</th>
        
      </tr>
    </thead>
    <tbody style="background:white;">

	<%
	try{
Connection	con = DBConnection.createConnection();
String sql ="select * from logininfo";
Statement s=con.createStatement();
ResultSet resultSet = s.executeQuery(sql);
%>

      <%  while(resultSet.next()){ 
    
      %>
      
        <tr>
     
        <td>      <%=resultSet.getString(2) %></td>
        <td>      <%=resultSet.getString(3)%></td>
        <td>      <%=resultSet.getString(4) %></td>
       
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
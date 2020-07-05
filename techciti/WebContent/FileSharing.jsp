<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.ananya.db.DBConnection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Alike' rel='stylesheet'>
	<title>
		title
	</title>
<style>
.cont{margin:5% 15% 0% 25%;background-color:white;width:55%;
}
	div.container2
	{
		background-color:white;margin-left:25%;margin-right:30%;width:55%;
	}

	body{
		background-color: black;
	}
	  .row {
  display: flex;
}

.column {
  flex:50%;

}
.share{
	padding-left: 10%;
	padding-right: 10%;
}

.headbtn{
	font-family: Alike;font-size: 1.4em; margin:5% 2% 5% 3%;
	}
</style>
<body>
	<div class="cont" style="">
	<div class="row">
	<div class="col">	
	<a href="Info File.jsp" class="btn btn-dark headbtn" >SHARED FILE</a></div>
	<div class="col">	<a href="ReceivedFile.jsp" class="btn btn-dark headbtn">RECEIVED FILE</a></div>
  <c:url var="logout" value="/LogoutServlet"></c:url>
	<div class="col">	<a href="${logout}" class="btn btn-dark headbtn">LOGOUT</a></div>
</div>
</div><br><br>
	<div class="container2"> 
   <div class="row">
	<div class="column" style="padding-left:5%;">
<form action="FileShareServlet" method="post">

 <h1 ><b>FILE SHARING</b></h1><br>
<table>
	<tr><td><h5>File Title</h5></td>
	<td> <input type="text" name="title" required></td></tr>

<tr><td><h5>Your File </h5></td>
	<td><h6 style="color: red;">${name }
	<%

	
	
	System.out.println(session.getAttribute("name")); %></h6></td></tr>
	

	<tr><td><h5>File Share Member</h5></td>
	<%
	try{
Connection	con = DBConnection.createConnection();
String sql ="select r.name from registration r where r.reg_id!="+(int)session.getAttribute("id");
Statement s=con.createStatement();
ResultSet resultSet = s.executeQuery(sql);

%>
	<td><select name="user">
      <%  while(resultSet.next()){ %>
      
          <option>
          <%=resultSet.getString("name") %>
          </option>
       <%} %>
    </select></td></tr></table>

<input class="btn btn-primary share" type="submit" value="SHARE" onclick="myFunction()"><br>

	</form>
	<script>
function myFunction() {
  alert("File is successfully shared");
}
</script>
	</div>
<div class="column" style="padding-left: 5%;">
	<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSqns6DkeoIMnPD4PaoqLIo3ETVJAiED2ICdpDlE3FNXNdg_9ue&usqp=CAU" >
	<br>
	<br>
</div>
</div>
</div>
	<%

        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>
</body>
</html>
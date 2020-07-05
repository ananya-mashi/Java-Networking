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
.cont{margin:5% 15% 0% 25%;background-color:white;width:55%;
}
	div.container2
	{
		background-color:white;margin-left:25%;margin-right:30%;
	}
@media screen and (max-width:800px) {
	
		div.container2{
			margin-left:15%;margin-right:10%;
		}
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
		.table{
	font-size: 1.4em;
}
</style>
<body>
	<div class="cont" >
	<div class="row">
	<div class="col">	
	<a href="Info File.jsp" class="btn btn-dark headbtn" >SHARED FILE</a></div>
	<div class="col">	<a href="ReceivedFile.jsp" class="btn btn-dark headbtn">RECEIVED FILE</a></div>
  <c:url var="logout" value="/LogoutServlet"></c:url>
	<div class="col">	<a href="${logout}" class="btn btn-dark headbtn">LOGOUT</a></div>
</div>
</div>

<br><br>

 <table class="table" style="margin:0% 5% 10% 20%; width:75%;">
    <thead style="color: white;background:#0d98ba ;">
      <tr>
        <th>Share Member Name</th>
        <th>File Name</th>
        <th>File</th>
         <th>Download File</th>
      </tr>
    </thead>
    <tbody style="background:white;">

	<%
	try{
Connection	con = DBConnection.createConnection();
String sql ="SELECT f.share_id,f.share_member_name,f.file_title, f.share_file FROM  file_share f order by f.share_id desc";
Statement s=con.createStatement();
ResultSet resultSet = s.executeQuery(sql);
%>

      <%  while(resultSet.next()){ 
      int i=resultSet.getInt(1);
      System.out.println(i);
      String str=String.valueOf(i);%>
      <c:url var="download" value="/FileDownloadServlet">
						<c:param name="share_id" value="<%=str%>" />
					</c:url>					
					
      
        <tr>
      <%if(resultSet.getString(3)!=null) {%>
        <td>      <%=resultSet.getString(2) %></td>
        <td>      <%=resultSet.getString(3) %></td>
        <td>   <textarea rows="5" cols="40"  >    <%=resultSet.getString(4) %></textarea></td>
        <td>
        <a href="${download }" style="color:green;"><b>Download</b></a></td>
        <%} %>
    </tr><%} %>
 </tbody>
</table>

	<%

        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>
</body>








</html>
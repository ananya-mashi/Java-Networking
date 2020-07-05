<%@ page import="com.google.gson.Gson" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.ananya.db.DBConnection"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<%
	
	Map<Object,Object> map = null;
	List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
	 
	try{
Connection	con = DBConnection.createConnection();
String sql ="select r.name,c.count,c.user_id from count c INNER JOIN registration r on c.user_id=r.reg_id";
Statement s=con.createStatement();
ResultSet resultSet = s.executeQuery(sql);

 while(resultSet.next()){ 
	Object name=resultSet.getString("name");
	Object count=(Integer)resultSet.getInt("count");
	 map = new HashMap<Object,Object>();
	
	 map.put("label",name);
	 map.put("y", count);
	 list.add(map);
 }
 Gson gson= new Gson();
String dataPoints =  gson.toJson(list);
      

    %>
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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
window.onload = function() { 
 
	var chart = new CanvasJS.Chart("chartContainer", {
		animationEnabled: true,
		theme: "light2",
	title: {
		text: "Attacker Details"
	},
	axisY: {title: "count",
		scaleBreaks: {
			
			type: "wavy",
			autoCalculate: true
		}
	
	},
	axisX: {
		title:"Attacker Name",
	},
	data: [{
		
		type: "column",
		indexLabel: "{y}",
		dataPoints: <%out.print(dataPoints);	System.out.println(dataPoints);%>
	}
	
]
		
});
chart.render();
 
}
</script>
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
</div><br><br>
<div id="chartContainer" style="height: 370px; width: 75%;margin-left:10%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
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
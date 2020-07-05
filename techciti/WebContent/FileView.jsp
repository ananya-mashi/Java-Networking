<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head><meta name="viewport" content="width=device-width, initial-scale=1">
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

	<div class="container2">
 <div class="row">
	<div class="column" style="padding-left:5%;">
<form action="FileContentView" method="post">
 <h1 ><b>FILE VIEW</b></h1><br><h2>File Content</h2><br>
 <textarea rows="5" cols="40" name="textArea">  
${text}
</textarea><br><br>


<%session.setAttribute("name",session.getAttribute("file_name"));

System.out.println(session.getAttribute("name"));%>
<br>

<input class="btn btn-primary share" type="submit" value="SHARE">

</form>
</div>
<div class="column" style="padding-left: 5%;">
	<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSqns6DkeoIMnPD4PaoqLIo3ETVJAiED2ICdpDlE3FNXNdg_9ue&usqp=CAU" >
	<br>
	<br>
</div>
</div>
</div>
</body>
</head>
</html>
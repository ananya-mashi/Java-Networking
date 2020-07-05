<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" >

	<title>
		title
	</title>
<style>
div.container1{
background-color:white;
margin-left:40%;
width:20%;
}

	body{
		background-color: black;
	}
	form input{
		border: none;
		background: transparent;
		border-bottom: 1px solid black;
		outline: none;
	}
	  .row {
  display: flex;
}

.column {
  flex:50%;

}
.headbtn{
	font-family: Alike; margin:5% 0% 5% 10%;font-size:1.8em;
}
.login{
	padding-left: 10%;
	padding-right: 10%;
}
</style>
</head>
<body>
<div align="center" style="color:white; font-size:2em;">
Title</div><br>

<div class="container1" align="center">
<div class="row">
<div class="col-sm-4" >	<a href="Userlogin.jsp" class="btn btn-dark headbtn" style="margin-top:8%;">User</a></div>
<div class="col-sm-3">	<a href="Adminlogin.jsp" class="btn btn-dark headbtn" style="margin-top:8%">Admin</a></div>
</div>
</div><br><br>
<div style="background-color:white;margin-left:30%;margin-right:10%">  <br> 



   <div class="row">
	<div class="column" style="padding-left:10%;">


<div align="center" class="img">

<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTVOB18LoYE1jtI6Gm3deeE6dB2yALtL0A1dZL-eJ7JPqEfmcZw&usqp=CAU"
 style="width:7%; size:fixed;">

  <h4 > Admin Login</h4><br>
 </div>
	<form action="AdminLoginServlet" enctype="multipart/form-data" method="post">
<input type="text" name="name" placeholder="Admin Name" required><br><br>

<input type="password"  name="password" placeholder="Password" pattern="[A-Za-z0-9]{8,}" 
title="Password contains atleast 8 character" required><br><br>

<br><br>
<input class="btn btn-primary login" type="submit" value="LOGIN"><br>

	</form>
	


</div>
<div class="column" style="padding-left:5%;">
	<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRBi4IDmFOaxnuuKBsP2lBfS7K4orDIl61_s_Iyg_PAAWwjGBXg&usqp=CAU" >
	<br>
	<br>
</div>
</div>
</div>

<footer style="text-align:center;width:100%;left:0; bottom:0;position:fixed; background-color:black; color:white;">

	title
</footer>


</body></html>
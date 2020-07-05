<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" >

	<title>
		title
	</title>
<style>

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
.login{
	padding-left: 10%;
	padding-right: 10%;
}
</style>
</head>
<body>
<div align="center" style="color:white; font-size:2em;">
Title</div><br>

<div style="background-color:white;margin-left:30%;margin-right:10%">  <br> 


<div align="center" class="img">

<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTVOB18LoYE1jtI6Gm3deeE6dB2yALtL0A1dZL-eJ7JPqEfmcZw&usqp=CAU"
 style="width:7%; size:fixed;">

  <h4 > User Login</h4><br>
 
 </div>
 
 
	<div  style="padding-left:10%;">
	<form action="LoginServlet" enctype="multipart/form-data" method="post">
<input type="text" name="name" placeholder="Name" required><br><br>

<input type="password"  name="password" placeholder="Password" pattern="[A-Za-z0-9]{8,}" 
title="Password contains atleast 8 character" required><br><br>
<div style="padding-left:10%;">
<b>Choose Image</b><br>
<input type="file" name="image" onchange="onFileSelected(event)"><br>
<br>
<img id="myimage" height="100" width="100">
<br>
<br>
<input type="reset" value="Reset">
</div>
<br><br>
<input class="btn btn-primary login" type="submit" value="LOGIN"><br>

	</form>
	<br>
	<br>
</div>

</div>



<script type="text/javascript">
	function onFileSelected(event) {
  var selectedFile = event.target.files[0];
  var reader = new FileReader();

  var imgtag = document.getElementById("myimage");
  imgtag.title = selectedFile.name;

  reader.onload = function(event) {
    imgtag.src = event.target.result;
  };

  reader.readAsDataURL(selectedFile);
}</script>

<footer style="text-align:center;width:100%;left:0; bottom:0;position:fixed; background-color:black; color:white;">

	title
</footer>


</body></html>
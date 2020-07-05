<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" >
<link href='https://fonts.googleapis.com/css?family=Alike' rel='stylesheet'>
	<title>
		title
	</title>
<style>
div.container1{
background-color:white;
margin-left:40%;
width:20%;
}
@media screen and (max-width:800px) {
	
		div.container2{
			margin-left:15%;margin-right:10%;
		}
	
}
	  .row1{
  display: flex;
}

.column {
  flex:50%;

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

.headbtn{
	font-family: Alike; margin:5% 0% 5% 10%;font-size:1.8em;
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
<div align="left" style="margin-left:10%">
	<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTzQCjnas63G1hpjs89Q-NL0CKdfNIyaGqe83FLCkL2Edy1BH1L&usqp=CAU">
</div>
<div style="background-color:white;margin-left:30%;margin-right:10%">  <br> 
  <h1 style="padding-left:8%;"> User Registration</h1><br>
  <div class="row1">
	<div class="column" style="padding-left:10%;">
	<form action="RegisterServlet" method="post" enctype="multipart/form-data" onsubmit="return validate()">
<input type="text" name="name" placeholder="Username" required><br><br>
<input type="email" name="email" placeholder="Email" required><br><br>
<b>Choose Image</b><br>
<input type="file" name="image"  onchange="onFileSelected(event)">
<div style="padding-left:50%">
Your Image<br>
<img id="image" height="20">
<br>
</div>
<input type="reset" value="Reset"><br><br>
<input type="password"  name="password" placeholder="Password" pattern="[A-Za-z0-9]{8,}" 
title="Password contains atleast 8 character" required><br><br>
<input type="password"  name="conpassword" placeholder="Confirm Password" pattern="[A-Za-z0-9]{8,}" 
title="Password contains atleast 8 character" required><br><br>

<input class="btn btn-primary" type="submit" value="Sign Up"><br>

	</form>
</div>
<div class="column" style="padding-left:5%;">
	<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRN8DpTRzEtCjPkPJ5CA7Rl880Oa8OseL-7x_hRPMwSuogy2KaX&usqp=CAU" >
</div>
</div>
	<div style=" padding-left:10%; font-size:1.2em;">
Already have an account...?<a href="Userlogin.jsp" style="color: red;"><b>LOGIN</b></a>

</div><br><br><br>
</div>

<script type="text/javascript">
	function onFileSelected(event) {
  var selectedFile = event.target.files[0];
  var reader = new FileReader();

  var imgtag = document.getElementById("image");
  imgtag.title = selectedFile.name;

  reader.onload = function(event) {
    imgtag.src = event.target.result;
  };

  reader.readAsDataURL(selectedFile);
}
function validate()
{  var password = document.form.password.value;
     var conpassword= document.form.conpassword.value;
   if (password!=conpassword)
     { 
     alert("Confirm Password should match with the Password"); 
     return false; 
     } 
 }
</script>



<footer style="text-align:center;width:100%;left:0; bottom:0;position:fixed; background-color:black; color:white;">

	title
</footer>


</body></html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,400i,700,900&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Approve Student Application</title>
</head>
<style>

input[type=button], input[type=submit] {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}

.button {
  background-color: red; 
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

body {
	text-align: center;
	padding: 40px 0;
	background-image: url(https://4kwallpaper.wiki/wp-content/uploads/2019/07/108049.jpg);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}

i {
	color: #9ABC66;
	font-size: 100px;
	line-height: 200px;
	margin-left: -15px;
}

.card {
	background: white;
	padding: 100px;
	border-radius: 50px;
	box-shadow: 0 3px 3px #C8D0D8;
	display: inline-block;
	margin: 0 auto;
}
</style>
<body>
	<div class="card">

		<form action="applicationApproveForm" method="GET">

		<label for="id"><b>Approve Application of Student with ID : </b></label> <input
			type="text" placeholder="Enter Student ID" name="id" required>
		<hr style="height:5px;border-width:0;color:gray;background-color:green">
		<input type="submit"  value="Approve" />
	</form>

				<hr style="height:5px;border-width:0;color:gray;background-color:red">
		<button class ="button" onclick="myFunction()">Home</button>

		<script>
			function myFunction() {
				location
						.replace("http://localhost:8080/spring-mvc-ds-2020-v2/home/")
			}
		</script>
	</div>
	<br>
	<br>
	<div id="footer">
		<%@ include file="Footer.jspf"%>
	</div>
</body>
</html>
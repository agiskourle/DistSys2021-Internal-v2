<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete User</title>
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
	background-image:
		url(https://4kwallpaper.wiki/wp-content/uploads/2019/07/108049.jpg);
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
		<form:form action="deleteUserForm" method="POST">
			<h1>Delete System User</h1>
			<p>
				<strong>FORM</strong>
			</p>

			<hr
				style="height: 3px; border-width: 0; color: gray; background-color: black">
			<label for="username"><b>Username : </b></label> <input type="text"
				placeholder="Enter Username" name="username" required>
			<hr
				style="height: 3px; border-width: 0; color: gray; background-color: black">

			<input type="submit" value="Delete" />
		</form:form>
		<hr
			style="height: 5px; border-width: 0; color: gray; background-color: green">
		<hr
			style="height: 5px; border-width: 0; color: gray; background-color: red">
		<button class="button" onclick="myFunction()">Admin Portal</button>

		<script>
			function myFunction() {
				location
						.replace("http://localhost:8080/spring-mvc-ds-2020-v2/admin/portal")
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
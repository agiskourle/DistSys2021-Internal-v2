<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Portal</title>
</head>
<body>
	<div id="header">
		<%@ include file="Header.jspf"%>
	</div>
	<div id="content">

		<h1 style="color: white; text-align: center;">Admin Portal</h1>
		<h3 style="color: white; text-align: center;">Welcome Admin:
			${pageContext.request.userPrincipal.name}</h3>
		<h4 style="color: white; text-align: center;">
			Role :
			<sec:authentication property="principal.authorities" />
		</h4>
		<h2 style="color: white; text-align: center;">Menu</h2>

		<p>Add User</p>
		<button class="button" onclick="myFunction1()">Add</button>
		<script>
			function myFunction1() {
				location
						.replace("http://localhost:8080/spring-mvc-ds-2020-v2/admin/portal/add")
			}
		</script>
		
		<p>Update User</p>
		<button class="button" onclick="myFunction2()">Update</button>
		<script>
			function myFunction2() {
				location
						.replace("http://localhost:8080/spring-mvc-ds-2020-v2/admin/portal/update")
			}
		</script>
		
				<p>Delete User</p>
		<button class="button" onclick="myFunction3()">Delete</button>
		<script>
			function myFunction3() {
				location
						.replace("http://localhost:8080/spring-mvc-ds-2020-v2/admin/portal/delete")
			}
		</script>

		<p>Home</p>
		<button class="button" onclick="myFunctionX()">Home</button>

		<script>
			function myFunctionX() {
				location
						.replace("http://localhost:8080/spring-mvc-ds-2020-v2/home/")
			}
		</script>


		<p>Log Out</p>
		<form:form action="${pageContext.request.contextPath}/logout"
			method="post">
			<input type="submit" value="Logout" />
		</form:form>

		<br>
	</div>
	<br>
	<br>
	<div id="footer">
		<%@ include file="Footer.jspf"%>
	</div>
</body>
</html>
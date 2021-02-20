<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home - System</title>
</head>
<body>
	<div id="header">
		<%@ include file="Header.jspf"%>
	</div>
	<div id="content">

		<h1 style="color: white; text-align: center;">USER PORTAL</h1>
		<h3 style="color: white; text-align: center;">Welcome User :
			${pageContext.request.userPrincipal.name}</h3>
		<h4 style="color: white; text-align: center;">
			User Rights :
			<sec:authentication property="principal.authorities" />
		</h4>
		<h2 style="color: white; text-align: center;">MENU</h2>

		<sec:authorize access="hasRole('ADMIN')">
			<p>Admin Portal</p>
			<button class="button" onclick="myFunctionx()">Portal</button>
			<script>
				function myFunctionx() {
					location
							.replace("http://localhost:8080/spring-mvc-ds-2020-v2/admin/portal")
				}
			</script>
		</sec:authorize>

		<sec:authorize access="hasRole('USER')">
			<p>Find Student / Find All Students</p>
			<button class="button" onclick="myFunction1()">Search
				Student</button>
			<script>
				function myFunction1() {
					location
							.replace("http://localhost:8080/spring-mvc-ds-2020-v2/home/find")
				}
			</script>

			
			<button class="button" onclick="myFunction5()">Search
				Students</button>
			<script>
				function myFunction5() {
					location
							.replace("http://localhost:8080/spring-mvc-ds-2020-v2/home/find-all")
				}
			</script>



			<p>Activate Student / Approve Student Application / Calculate Points for Student</p>
			<button class="button" onclick="myFunction2()">Activate
				Student</button>
			<script>
				function myFunction2() {
					location
							.replace("http://localhost:8080/spring-mvc-ds-2020-v2/home/activate")
				}
			</script>

			<button class="button" onclick="myFunction3()">Approve
				Application</button>
			<script>
				function myFunction3() {
					location
							.replace("http://localhost:8080/spring-mvc-ds-2020-v2/home/approve")
				}
			</script>

			<button class="button" onclick="myFunction4()">Calculate
				Points</button>
			<script>
				function myFunction4() {
					location
							.replace("http://localhost:8080/spring-mvc-ds-2020-v2/home/points")
				}
			</script>
			
			<p>Update Students Ranking</p>

			<button class="button" onclick="myFunction6()">Update
				Ranking</button>
			<script>
				function myFunction6() {
					location
							.replace("http://localhost:8080/spring-mvc-ds-2020-v2/home/ranking")
				}
			</script>

			<p>Clear Database Records</p>
			<button class="button" onclick="myFunction7()">Clear</button>
			<script>
				function myFunction7() {
					location
							.replace("http://localhost:8080/spring-mvc-ds-2020-v2/home/clear")
				}
			</script>
		</sec:authorize>

		<p>Log Out</p>
		<form:form action="${pageContext.request.contextPath}/logout"
			method="post">
			<input type="submit" value="Logout" />
		</form:form>

		
	</div>
	<br>
	<br>
	<div id="footer">
		<%@ include file="Footer.jspf"%>
	</div>
<body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Students</title>
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
	background-image:
		url(https://4kwallpaper.wiki/wp-content/uploads/2019/07/108049.jpg);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	color: white;
}

table {
	width: 75%;
		 margin-left: auto;
  margin-right: auto;
}

table, th, td {
	border: 0px solid black;
	border-collapse: collapse;
	color: red;
	
}

th, td {
	padding: 15px;
	text-align: center;
}

#t01 tr:nth-child(even) {
	background-color: #eee;
}

#t01 tr:nth-child(odd) {
	background-color: #fff;
}

#t01 th {
	background-color: green;
	color: white;
}
</style>
</head>
<body>
	<br>
	<h1>Housing System Database</h1>
	<br>
	<h2>Records of Students</h2>
	<br>

	<table id="t01">

		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>DEPARTMENT</th>
			<th>SEMESTER</th>
			<th>PHONE</th>
			<th>EMAIL</th>
			<th>LOCAL</th>
			<th>HOUSING YEARS</th>
			<th>APPLICATION SENT</th>
			<th>ACTIVATION STATUS</th>
			<th>POINTS</th>
			<th>RANKING</th>
			<th>APPLICATION STATUS</th>
		</tr>
		<!-- loop over and print our customers -->
		<c:forEach var="studentObj" items="${studentObj}">

			<tr>
				<td>${studentObj.id}</td>
				<td>${studentObj.name}</td>
				<c:choose>
					<c:when test="${studentObj.department =='dit'}">
						<td>Informatics</td>
					</c:when>
					<c:when test="${studentObj.department =='geo'}">
						<td>Geography</td>
					</c:when>
					<c:otherwise>
						<td> Nutrition-Dietetics</td>
					</c:otherwise>
				</c:choose>
				<td>${studentObj.semester}</td>
				<td>${studentObj.phone}</td>
				<td>${studentObj.email}</td>
				<c:choose>
					<c:when test="${studentObj.locality==false}">
						<td>NO</td>
					</c:when>
					<c:otherwise>
						<td>YES</td>
					</c:otherwise>
				</c:choose>
				<td>${studentObj.housing_years}</td>
				<c:choose>
					<c:when test="${studentObj.application_sent==false}">
						<td>NO</td>
					</c:when>
					<c:otherwise>
						<td>YES</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${studentObj.activation_status==false}">
						<td>NOT ACTIVATED</td>
					</c:when>
					<c:otherwise>
						<td>ACTIVATED</td>
					</c:otherwise>
				</c:choose>
				<td>${studentObj.points}</td>
				<td>${studentObj.ranking}</td>
				<c:choose>
					<c:when test="${studentObj.application_approved==false}">
						<td>NOT APPROVED</td>
					</c:when>
					<c:otherwise>
						<td>APPROVED</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
		<tr>
	</table>

	<br>
	<button class="button" onclick="myFunction()">Home</button>

	<script>
		function myFunction() {
			location
					.replace("http://localhost:8080/spring-mvc-ds-2020-v2/home/")
		}
	</script>
	
	<br>
	<br>
	<div id="footer">
		<%@ include file="Footer.jspf"%>
	</div>
</body>
</html>
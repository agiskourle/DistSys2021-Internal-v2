<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Student</title>
</head>
<style>
.button {
	background-color: red;
	border: none;
	color: white;
	padding: 15px 30px;
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
	width: 50%;
	padding: 30px;
	background: gray;
	 margin-left: auto;
  margin-right: auto;
}

table, th, td {
	border-spacing: 25px;
	border: 0px solid black;
}

th, td {
	padding: 35px;
	text-align: center;
	border: 0px solid black;
}

#t01 tr:nth-child(even) {
	background-color: brown;
	
}

#t01 th {
border: 0px solid black;
	background-color: green;
	color: white;
}
</style>
</head>
<body>
<br>
	<h1>Housing System Database</h1>
	<h2>Student Information With ID : ${studentObj.id}</h2>
<br>


	<table id="t01">
		<tr>
			<th>NAME</th>
			<th>DEPARTMENT</th>
			<th>SEMESTER</th>
			<th>PHONE</th>
			<th>EMAIL</th>
			<th>LOCALITY</th>
		</tr>
		<tr>

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
		</tr>
		<tr>
			<th>HOUSING YEARS</th>
			<th>APPLICATION SENT</th>
			<th>ACTIVATION STATUS</th>
			<th>POINTS</th>
			<th>RANKING</th>
			<th>APPLICATION APPROVED</th>
		</tr>
		<tr>

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
	</table>

	<br>
	<button class="button" onclick="myFunction()">Home</button>

	<script>
		function myFunction() {
			location
					.replace("http://localhost:8080/spring-mvc-ds-2020-v2/home/")
		}
	</script>
	<div id="footer">
		<%@ include file="Footer.jspf"%>
	</div>
</body>
</html>

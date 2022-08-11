<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>

td{text-align : center}
</style>
</head>
<body>

	<h1>Students List</h1>
	<table border="2" width="60%" cellpadding="2">
		<tr>
			<th>StudentId</th>
			<th>StudentName</th>
			<th>Course</th>
			<th>Fee</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="student" items="${studentsList}">
			<tr>
				<td>${student.studentId}</td>
				<td>${student.studentName}</td>
				<td>${student.course}</td>
				<td>${student.fees}</td>
				<td><a href="editstudent/${student.studentId}">Edit</a></td>
				<td><a href="deletestudent/${student.studentId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="addStudentForm">Add New Student</a>

</body>
</html>
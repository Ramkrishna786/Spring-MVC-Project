<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Student Form</h1>
	<form:form action="/SpringMVC1/updatestudentDetails" method="post"	modelAttribute="student">

		<table>
			<tr>
				<td><form:hidden path="studentId" /></td>
			</tr>

			<tr>
				<td>StudentName :</td>
				<td><form:input path="studentName" /></td>
			</tr>

			<tr>
				<td>Course :</td>
				<td><form:input path="course" /></td>
			</tr>

			<tr>
				<td>Fee :</td>
				<td><form:input path="fees" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>
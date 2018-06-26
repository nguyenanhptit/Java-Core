<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Student</title>
</head>
<body>
	<h2>Please input student information</h2>
	<%-- <c:if test="${isAdd eq '0'}"> --%>
	<form:form method="POST" action="form" modelAttribute="student">
		<form:hidden path="id" />
		<table>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" type="text" />
			</tr>
			<tr>
				<td>Age:</td>
				<td><form:input path="age" type="number" />
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form:form>
	<c:if test="${id != null}">
		<h1>Please upload image</h1>
		<form method="post" action="../avatar/save"
			enctype="multipart/form-data">
			<input type="hidden" name="id" value="${id}" /> <input type="file"
				name="file" /> <input type="submit" value="upload" />
		</form>
	</c:if>
</body>
</html>
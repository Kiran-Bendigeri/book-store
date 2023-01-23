<%@page import="javax.servlet.annotation.WebServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Enter book details</h1>

	<form action="insert" method="">

		Enter the book id : <input type="number" name="id" required="required" placeholder="book id"><br>
		<br> Enter the book name : <input type="text" name="name" required="required" placeholder="book name"><br>
		<br> Enter the book author : <input type="text" name="author"required="required" placeholder="author"><br>
		<br> Enter the number of pages : <input type="number" name="pages" required="required"placeholder="pages"><br>
		<br> Enter the price : <input type="number" name="price" required="required" placeholder="price"><br>
		<br> <input type="submit" value="Save">
		<input type="reset" value="Reset">

	</form>
	<br><br><br>
	<h1>Get book details</h1>
	<form action="getbook" method="">

		Enter the book id : <input type="number" name="id" required="required" placeholder="book id"><br>
		<br> <input type="submit" value="Submit">
		<input type="reset" value="Reset">

	</form>
	

</body>
</html>
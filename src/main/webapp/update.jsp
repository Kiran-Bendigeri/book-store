<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book details</title>
</head>
<body>

	<%
		int id = (int)request.getAttribute("id");
		String bookName = (String)request.getAttribute("book name");
		String bookAuthor = (String)request.getAttribute("book author");
		int pages = (int)request.getAttribute("pages");
		double price = (double)request.getAttribute("price");
	%>

	<h1>Update book</h1>
	
	<form action="update2">
		
		Book id : <input type="number" value=<%=id %> name="id" readonly="readonly"> <br><br>
		Book name : <input type="text" value=<%=bookName %> name="book name"> <br><br>
		Book Author : <input type="text" value=<%=bookAuthor %> name="book author"> <br><br>
		Book pages : <input type="number" value=<%=pages %> name="pages"> <br><br>
		Book price : <input type="number" value=<%=price %> name="price"> <br><br>
		<input type="submit" value="Submit"> <br><br>
	
	</form>
	
	

</body>
</html>
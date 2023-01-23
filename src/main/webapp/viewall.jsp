<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All books</title>
</head>
<body>

	<script	type="text/javascript">
		function getConfirmation() {
			var value = confirm("Do you want to continue to delete");
				if (value == true) {
					return true;
				} else return false;
		}
	</script>


	<table border="2px solid blue" cellspacing="0px" cellpadding="10px">
		
		<tr>
			<th>BookID</th>
			<th>Book name</th>
			<th>Book author</th>
			<th>Pages</th>
			<th>Price</th>
			<th>Delete book</th>
			<th>Update book</th>
		</tr>


		<%@ page import="java.util.*, com.js.dto.*"%>

		<%ArrayList<Book> book = (ArrayList) request.getAttribute("Books");%>

		<%for (Book b : book) {%>

		<tr>
			<td><%=b.getBook_id()%></td>
			<td><%=b.getBook_name()%></td>
			<td><%=b.getAuthor()%></td>
			<td><%=b.getPages()%></td>
			<td><%=b.getPrice()%></td>
			<td><a href="delete?id=<%=b.getBook_id()%>">Delete</a></td>
			<td><a href="update?id=<%=b.getBook_id()%>">Update</a></td>
			<td><input type="button" value="Delete" formaction="delete?id=<%=b.getBook_id()%>" onclick="getConfirmation()"/> 
				
		</tr>

		<%}%>
		
	</table>

	<h3>
		<a href="welcome.html">Click here to go home</a>
	</h3>

</body>
</html>
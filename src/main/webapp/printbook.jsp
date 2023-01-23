<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
  	<%@ page import="com.js.dto.Book" %>
  	
    <%	Book book = (Book)request.getAttribute("book");
    	if(book != null){%>
    		<h2 class="head">book id :  <%= " "+book.getBook_id()%> </h2>
    		<h2 class="head">book name :  <%= " "+book.getBook_name()%> </h2>
    		<h2 class="head">book author :  <%= " "+book.getAuthor()%> </h2>
    		<h2 class="head">pages :  <%= " "+book.getPages()%> </h2>
    		<h2 class="head">price :  <%= " "+book.getPrice()%> </h2>
    	<%} else {%>
    		<h2>Book not found</h2>
    <%}%>
</body>
</html>
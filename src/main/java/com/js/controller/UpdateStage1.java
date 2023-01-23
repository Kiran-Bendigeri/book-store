package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.CRUD;
import com.js.dto.Book;

@WebServlet("/update")
public class UpdateStage1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		CRUD crud = new CRUD();
		Book book = crud.getBookByID(Integer.parseInt(req.getParameter("id")));
		
		if(book != null) {
			req.setAttribute("id", book.getBook_id());
			req.setAttribute("book name", book.getBook_name());
			req.setAttribute("book author", book.getAuthor());
			req.setAttribute("pages", book.getPages());
			req.setAttribute("price", book.getPrice());
			
			RequestDispatcher rd = req.getRequestDispatcher("update.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("msg", "Book not available");
			RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
			rd.forward(req, resp);
		}
		
	}
}

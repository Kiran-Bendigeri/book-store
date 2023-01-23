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

@WebServlet("/insert")
public class InsertBook extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Book book = new Book();
		book.setBook_id(Integer.parseInt(req.getParameter("id")));
		book.setBook_name(req.getParameter("name"));
		book.setAuthor(req.getParameter("author"));
		book.setPages(Integer.parseInt(req.getParameter("pages")));
		book.setPrice(Double.parseDouble(req.getParameter("price")));
		
		CRUD crud = new CRUD();
		if(crud.insertBook(book)>0) {
			req.setAttribute("msg", "Book is saved successfully");
			RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute("msg", "Book is not saved");
			RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
			rd.forward(req, resp);
		}
	}
	

}

package com.js.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.CRUD;
import com.js.dto.Book;

@WebServlet("/view")
public class ViewAllBooks extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CRUD crud = new CRUD();
		ArrayList<Book> al = crud.getAllBooks();
		
		if(al.isEmpty()) {
			req.setAttribute("msg", "No books available");
			RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("Books", al);
			RequestDispatcher rd = req.getRequestDispatcher("viewall.jsp");
			rd.forward(req, resp);
		}
		
	}

}

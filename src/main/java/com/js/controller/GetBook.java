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

@WebServlet("/getbook")
public class GetBook extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CRUD crud = new CRUD();

		Book book = crud.getBookByID(Integer.parseInt(req.getParameter("id")));
			
			req.setAttribute("book", book);
			
			RequestDispatcher rd = req.getRequestDispatcher("printbook.jsp");
			rd.forward(req, resp);

	}

}

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

@WebServlet("/update2")
public class UpdateStage2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book = new Book(Integer.parseInt(req.getParameter("id")), req.getParameter("book name"),
				req.getParameter("book author"), Integer.parseInt(req.getParameter("pages")),
				Double.parseDouble(req.getParameter("price")));
		
		CRUD crud = new CRUD();
		int count = crud.updateBook(book.getBook_id(), book);
		
		if(count > 0) {
			RequestDispatcher rd = req.getRequestDispatcher("view");
			rd.forward(req, resp);
		}else {
			req.setAttribute("msg", "Book Not updated");
			RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
			rd.forward(req, resp);
		}

	}

}

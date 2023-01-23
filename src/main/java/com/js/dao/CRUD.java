package com.js.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.js.dto.Book;

public class CRUD {

	final static String path = "com.mysql.cj.jdbc.Driver";
	final static String address = "jdbc:mysql://localhost:3306/book_store?user=root&password=root";
	Connection c;

	public int insertBook(Book b) {
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("INSERT INTO book VALUES(?,?,?,?,?)");
			ps.setInt(1, b.getBook_id());
			ps.setString(2, b.getBook_name());
			ps.setString(3, b.getAuthor());
			ps.setInt(4, b.getPages());
			ps.setDouble(5, b.getPrice());

			// returns number of rows affected
			return ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException o) {
			o.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;

	}

	public int deleteBookById(int id) {
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("delete from book where book_id=?");
			ps.setInt(1, id);
			return ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;

	}

	public int getBookDetails(int id) {
		try {

			Class.forName(path);
			c = DriverManager.getConnection(address);
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("Select * from book");

			while (rs.next()) {
				if (rs.getInt(1) == id)
					System.out.printf("id=%d, name=%s, author=%s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;

	}

	public int updateBook(int id, Book book) {
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("update book set book_name=?, author=?, pages=?, price=? where book_id=?");
			ps.setString(1, book.getBook_name());
			ps.setString(2, book.getAuthor());
			ps.setInt(3, book.getPages());
			ps.setDouble(4, book.getPrice());
			ps.setInt(5, id);

			return ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public Book getBookByID(int id) {
		Book book = null;

		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("SELECT * FROM book where book_id=?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				if (rs.getInt(1) == id) {
//					System.out.printf("book_id=%d, book_name=%s, book_author=%s, pages=%d, book_price=%d\n",
//							rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
//					System.out.println("Got the book");
					book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5));
					return book;
				} 
				
//				else System.out.println("Book Not Found");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return book;
	}
	
	public ArrayList<Book> getAllBooks(){
		ArrayList<Book> books=new ArrayList<Book>();
		
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM book");
			
			while(rs.next()) {
				Book book=new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5));
				books.add(book);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return books;
		}
	}
	
	// Batch execution : Process of inserting number of objects into database
	
//	public boolean insertAllBooks(ArrayList<List<Book>> books) {
//		boolean bool=true;
//		
//	}

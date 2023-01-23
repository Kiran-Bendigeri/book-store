package com.js.dto;

public class Book {

	private int book_id;
	private String book_name;
	private String author;
	private int pages;
	private double price;

	public Book(int book_id, String book_name, String author, int pages, double price) {
		this.book_id = book_id;
		this.book_name = book_name;
		this.author = author;
		this.price = price;
		this.pages = pages;
	}

	public Book() {
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


}

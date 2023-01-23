package com.js.dto;

import java.util.ArrayList;

public class NovelBook extends Book{

	public static void main(String[] args) {
		Book b1 = new Book();
		NovelBook b2 = new NovelBook();
		b1 = b2;
//		b2 = b1;// compilation error
		System.out.println(b1);
		System.out.println(b2);
		
//		ArrayList<Book> al1= new ArrayList<>();
//		ArrayList<?> al2 = new ArrayList<>();
//		al2=al1;
		
		ArrayList<? extends Book> al1= new ArrayList<>();
		ArrayList<NovelBook> al2 = new ArrayList<>();
		al1=al2;
		
		ArrayList<? super Book> al3 = new ArrayList<>();
		ArrayList<Object> al4 = new ArrayList<>();
		al1=al2;
	}

}

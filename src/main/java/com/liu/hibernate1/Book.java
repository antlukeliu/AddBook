package com.liu.hibernate1;

public class Book {
	private int rank;
	private String title;
	private String author;
	private int sales;
	private String imprint;
	private String publisher;
	private int yearPublished;
	private String genre;
	private int status;
	private int borrower;
	
	public Book() {
		super();
	}

	public int getRank() {
		return rank;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getSales() {
		return sales;
	}

	public String getImprint() {
		return imprint;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public String getGenre() {
		return genre;
	}

	public int getStatus() {
		return status;
	}

	public int getBorrower() {
		return borrower;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public void setImprint(String imprint) {
		this.imprint = imprint;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setBorrower(int borrower) {
		this.borrower = borrower;
	}
	
}

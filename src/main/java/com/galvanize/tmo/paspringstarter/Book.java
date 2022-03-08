package com.galvanize.tmo.paspringstarter;

import org.json.JSONObject;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
class Book implements java.lang.Comparable<Book> {

//  private @Id @GeneratedValue Long id;
 	private Long id;
	private String title;
	private String author;
	private Long yearPublished;

	Book() {}

	Book(String title, String author, Long yearPublished) {
		this.title = title;
		this.author = author;
		this.yearPublished = yearPublished;
	}

	public Long getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public Long getYearPublished() {
		return this.yearPublished;
	}

	public String getSortKey() {
	    String key = this.title + " " + this.author + " " + this.yearPublished.toString();
	    return key;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYearPublished(Long yearPublished) {
		this.yearPublished = yearPublished;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Book))
			return false;

		Book book = (Book) o;
		return Objects.equals(this.id, book.id) &&
		       Objects.equals(this.title, book.title) &&
		       Objects.equals(this.author, book.author) &&
		       Objects.equals(this.yearPublished, book.yearPublished);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.title, this.author, this.yearPublished);
	}

	@Override
	public String toString() {
		return "Book{id=" + this.id + ", title='" + this.title + "', author='" + this.author
			+ "', yearPublished='" + this.yearPublished.toString() + "'" + "}";
	}

	public JSONObject toJSON() {
		JSONObject entity = new JSONObject();
		entity.put("author", this.author);
		entity.put("id", this.id);
		entity.put("title", this.title);
		entity.put("yearPublished", this.yearPublished);
		return(entity);
	}
	
	@Override
	public int compareTo(Book b2) {
        return this.getSortKey().compareTo(b2.getSortKey());
	}
}

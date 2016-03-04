package com.luckypants.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

	private String title;
	private String author;
	private String ISBN;
	
	 @JsonDeserialize(as=ArrayList.class, contentAs=String.class)
	private ArrayList<String> genres;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	public ArrayList<String> getGenres() {
		return genres;
	}
	 @JsonDeserialize(as=ArrayList.class, contentAs=String.class)
	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}

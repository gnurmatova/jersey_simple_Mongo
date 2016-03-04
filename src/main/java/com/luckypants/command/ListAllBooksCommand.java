package com.luckypants.command;

import java.util.ArrayList;

import org.bson.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luckypants.model.Book;
import com.luckypants.mongo.ConnectionProvider;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ListAllBooksCommand {
	ObjectMapper mapper = new ObjectMapper();

	public ArrayList<Book> execute() {
		MongoClient client = (new ConnectionProvider()).getConnection();
		MongoDatabase mdb = client.getDatabase("unhedu");
		MongoCollection<Document> booksColl = mdb.getCollection("books");
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			FindIterable<Document> cursor = booksColl.find();
			for (Document c : cursor) {
				Book b = mapper.convertValue(c, Book.class);

				books.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		finally{
			client.close();
		}
		return books;

	}
}

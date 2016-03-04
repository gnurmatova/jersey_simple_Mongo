package com.luckypants.command;

import org.bson.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luckypants.model.Book;
import com.luckypants.mongo.ConnectionProvider;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CreateBookCommand {

	public boolean execute(Book book) {
		MongoClient client = (new ConnectionProvider()).getConnection();
		MongoDatabase mdb = client.getDatabase("unhedu");
		MongoCollection<Document> booksColl = mdb.getCollection("books");

		ObjectMapper mapper = new ObjectMapper();
		try {
			Document dbObject = new Document(Document.parse(mapper.writeValueAsString(book)));
			booksColl.insertOne(dbObject);
		} catch (Exception e) {
			System.out.println("ERROR during mapping book to Mongo Object");
			return false;
		}
		finally{
			client.close();
		}

		return true;
	}

}

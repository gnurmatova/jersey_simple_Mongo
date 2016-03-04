package com.luckypants.command;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luckypants.model.Book;
import com.luckypants.mongo.ConnectionProvider;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class GetBookCommand {
	ObjectMapper mapper = new ObjectMapper();

	public Book execute(String key, String value) {
		MongoClient client = (new ConnectionProvider()).getConnection();
		MongoDatabase mdb = client.getDatabase("unhedu");
		MongoCollection<Document> booksColl = mdb.getCollection("books");

		BasicDBObject searchQuery = new BasicDBObject();
		if (key.equals("_id")) {
			searchQuery.put(key, new ObjectId(value));
		} else {
			searchQuery.put(key, value);
		}

		FindIterable<Document> book = booksColl.find(searchQuery);

		client.close();

		return mapper.convertValue(book.first(), Book.class);
	}

}

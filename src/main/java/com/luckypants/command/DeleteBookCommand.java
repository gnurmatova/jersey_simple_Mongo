package com.luckypants.command;

import org.bson.Document;

import com.luckypants.mongo.ConnectionProvider;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DeleteBookCommand {

	public boolean execute(String isbn) {
		MongoClient client = (new ConnectionProvider()).getConnection();
		MongoDatabase mdb = client.getDatabase("unhedu");
		MongoCollection<Document> booksColl = mdb.getCollection("books");

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("isbn", isbn);

		booksColl.deleteOne(searchQuery);

		client.close();

		return true;
	}

}

package com.luckypants.mongo;

import java.util.Arrays;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;

public class ConnectionProvider {

	public MongoClient getConnection() {
		try {

			MongoCredential credential = MongoCredential.createCredential("unh", "unhedu", "unh".toCharArray());
			MongoClient client = new MongoClient(new ServerAddress("ds053764.mlab.com", Integer.valueOf("53764")),
					Arrays.asList(credential));
			
			return client;
		} catch (MongoException e) {
			e.printStackTrace();
		}
		return null;

	}

}

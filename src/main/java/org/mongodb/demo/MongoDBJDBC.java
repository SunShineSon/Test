package org.mongodb.demo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDBJDBC {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
		DB db = mongoClient.getDB("shop");
		DBCollection dbcollectoion = db.getCollection("manager");
		BasicDBObject doc = new BasicDBObject("title-A", "MongoDB")
				.append("description", "database")
				.append("likes", 100)
				.append("url", "http://www.w3cschool.cc/mongodb/")
				.append("by", "w3cschool.cc");
		dbcollectoion.insert(doc);
		System.out.println("Document inserted successfully");
	}

	@SuppressWarnings("deprecation")
	private static void createCollection() {
		MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
		DB db = mongoClient.getDB("shop");
		String collectionName = "manager1";
		DBObject doc = new BasicDBObject("name", "A").append("age", 20).append(
				"sex", "��");
		DBCollection dbCollection = db.createCollection(collectionName, doc);
		dbCollection.insert(doc);
		System.out.println("Collection mycol selected successfully!");
	}

	@SuppressWarnings("deprecation")
	private static void createDB() {
		try {
			// ���ӵ� mongodb ����
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			// ���ӵ����ݿ�
			DB db = mongoClient.getDB("test");
			System.out.println("Connect to database successfully");
			DBCollection collection = db.getCollection("teacher");

			long count = collection.getCount();
			System.out.println(count);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

}

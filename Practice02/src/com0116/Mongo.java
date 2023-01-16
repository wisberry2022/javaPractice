package com0116;

import java.util.Date;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Mongo {
	static int num = 10;
	static MongoCollection<Document> sales;
	
	public static Document insertDoc(String item, double price, int quantity) {
		Document doc = new Document();
		long idx = sales.countDocuments();
		doc.append("_id", idx+1);
		doc.append("item", item);
		doc.append("price", price);
		doc.append("quantity", quantity);
		doc.append("date", new Date());
		return doc;
	}
	
	public static void main(String[] args) {
		String uri = "mongodb://localhost:27017";
		
		MongoClient mongoClient = MongoClients.create(uri);
		MongoDatabase database = mongoClient.getDatabase("sample");
		sales = database.getCollection("sales");
		System.out.println(sales.countDocuments());
		
		
		// 검색
		FindIterable<Document> doc = sales.find(new Document().append("price", new Document().append("$gte", 10) ));
		
		MongoCursor<Document> ite = doc.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		// 삽입
		sales.insertOne(insertDoc("fez", 8.5, 10));
	}

}


//MongoDB에서 db 리스트 뽑아내기
//MongoIterable<String> mi = mongoClient.listDatabaseNames();
//Iterator<String> ite = mi.iterator();
//while(ite.hasNext()) {
//	System.out.println(ite.next());
//}
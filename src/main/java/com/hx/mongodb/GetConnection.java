package com.hx.mongodb;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created  on 2019/04/05.
 */
public class GetConnection {

    public static void main(String[] args){
        MongoClient mongoClient = new MongoClient("hadoop103", 27017) ;
//        MongoDatabase database = mongoClient.getDatabase("local");
//        MongoCollection<Document> collection = database.getCollection("cainiao");

        //System.out.println(collection.countDocuments());
        //System.out.println(collection.find().first().toJson());
        // System.out.println(collection.find().iterator());
//        MongoCursor<Document> iterator = collection.find().iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next().toJson());
//        }
//        iterator.close();



        //===============创建===========================
        MongoDatabase client = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = client.getCollection("users");

       // Document document=new Document("name","明华");

        Map<String,Object> map=new HashMap<>();
        map.put("name","陈");
        map.put("sex","男");
        map.put("age",16);
        Document document=new Document(map);

      //  collection.insertOne(document);
        collection.insertOne(document);
    }



    @Test
    public void testObj(){
        MongoClient mongoClient = new MongoClient("hadoop103", 27017) ;
        MongoDatabase client = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = client.getCollection("students");
//
//        Student student=new Student("4","lucy",19);
//
//            Gson gson=new Gson();
//        String stuJson = gson.toJson(student);
//
//        Document document=Document.parse(stuJson);
//
//        collection.insertOne(document);

//        Document document = collection.find().first();
//
//        Student student = gson.fromJson(document.toJson(), Student.class);
 //       System.out.println(student);


        UpdateResult result = collection.updateOne(Filters.eq("name", "lucy"), new Document("$set", new Document("age", 22)));
        long count = result.getMatchedCount();
        System.out.println(count);

    }

}

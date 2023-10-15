package com.fricle.joblisting.repository;

import com.fricle.joblisting.model.Post;
import com.mongodb.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;

@Component
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter mongoConverter;
    @Value("${spring.data.mongodb.database}")
    private String databaseName;
    @Override
    public List<Post> findByText(String text) {
        System.out.println("text "+text);
        final List<Post> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase(databaseName);
        MongoCollection<Document> collection= database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query",text)// tells that query for java
                                .append("path",Arrays.asList("techs","desc","profile")))), // search it in tech desc and profile
                new Document("$sort",
                        new Document("exp",1L)), // sorting based on exp and 1l means ascending order
                new Document("$limit",5L))); //want to see only 5 post

        result.forEach(doc->posts.add(mongoConverter.read(Post.class,doc)));

        return posts;
    }
}

package com.fricle.joblisting.repository;

import com.fricle.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {
    //mongo repository takes care of all crud

}

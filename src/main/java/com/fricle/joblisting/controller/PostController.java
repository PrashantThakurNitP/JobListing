package com.fricle.joblisting.controller;

import com.fricle.joblisting.model.Post;
import com.fricle.joblisting.repostory.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
    @GetMapping(value = "/posts")
    public List<Post>getAllPosts(){
        return postRepository.findAll();

    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){//data submitted from client side will be accepted in post
      return   postRepository.save(post);
    }
}

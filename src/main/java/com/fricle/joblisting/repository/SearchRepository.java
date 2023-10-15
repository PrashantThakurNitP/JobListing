package com.fricle.joblisting.repository;

import com.fricle.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {
  List<Post> findByText(String text);
}

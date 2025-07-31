package com.blog.Blogging.Project.repository;

import com.blog.Blogging.Project.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer> {
}

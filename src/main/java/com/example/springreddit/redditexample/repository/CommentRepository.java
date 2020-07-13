package com.example.springreddit.redditexample.repository;

import com.example.springreddit.redditexample.model.Comment;
import com.example.springreddit.redditexample.model.Post;
import com.example.springreddit.redditexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}

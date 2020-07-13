package com.example.springreddit.redditexample.repository;

import com.example.springreddit.redditexample.model.Post;
import com.example.springreddit.redditexample.model.Subreddit;
import com.example.springreddit.redditexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);

}

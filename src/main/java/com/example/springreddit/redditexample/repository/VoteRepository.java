package com.example.springreddit.redditexample.repository;


import com.example.springreddit.redditexample.model.Post;
import com.example.springreddit.redditexample.model.User;
import com.example.springreddit.redditexample.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}

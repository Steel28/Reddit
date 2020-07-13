package com.example.springreddit.redditexample.exceptions;

public class SubredditNotFoundException extends RuntimeException {

        public SubredditNotFoundException(String message) {
            super(message);
        }

}

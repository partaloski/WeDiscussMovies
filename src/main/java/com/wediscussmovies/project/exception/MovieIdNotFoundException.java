package com.wediscussmovies.project.exception;

public class MovieIdNotFoundException extends RuntimeException{
    public MovieIdNotFoundException(Long id){
        super("Movie with that id=" + id + " does not exist!");
    }
}

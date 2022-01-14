package com.wediscussmovies.project.web.controller;

import com.wediscussmovies.project.model.Movie;
import com.wediscussmovies.project.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String getMovies(@RequestParam(required = false) String titleQuery, Model model){
        List<Movie> movies;
        if(titleQuery == null || titleQuery.isEmpty()) {
            movies = movieService.listAll();
        }
        else{
            movies = movieService.searchByTitle(titleQuery);
        }
        model.addAttribute("movies", movies);
        model.addAttribute("contentTemplate", "moviesList");
        return "template";
    }

}

package com.wediscussmovies.project.web.controller;

import com.wediscussmovies.project.model.Genre;
import com.wediscussmovies.project.model.Movie;
import com.wediscussmovies.project.model.Person;
import com.wediscussmovies.project.model.exception.MovieIdNotFoundException;
import com.wediscussmovies.project.service.GenreService;
import com.wediscussmovies.project.service.MovieService;
import com.wediscussmovies.project.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final GenreService genreService;
    private final PersonService personService;

    public MovieController(MovieService movieService, GenreService genreService, PersonService personService) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.personService = personService;
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

        movies.sort(Movie.comparatorTitle);

        model.addAttribute("movies", movies);
        model.addAttribute("contentTemplate", "moviesList");
        return "template";
    }


    @GetMapping("/add")
    public String addMovie(Model model){
        model.addAttribute("directors", personService.findAllDirectors());
        model.addAttribute("actors", personService.findAllActors());
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("contentTemplate", "moviesAdd");
        return "template";
    }


    @PostMapping("/{id}/delete")
    public String addMovie(@PathVariable int id){
        Optional<Movie> movie = movieService.findById(id);
        if(movie.isPresent()){
            movieService.deleteById(movie.get().getMovie_id());
        }
        return "redirect:/movies";
    }

    @PostMapping("/add/confirm")
    public String addMoviePost(@RequestParam String title,
                               @RequestParam String description,
                               @RequestParam String image_url,
                               @RequestParam Date airing_date,
                               @RequestParam Float rating,
                               @RequestParam Integer director_id,
                               @RequestParam List<Integer> actors,
                               @RequestParam List<Integer> genres,
                               Model model){
        if(title == null || title.isEmpty() ||
        description == null || description.isEmpty() ||
        image_url == null || image_url.isEmpty() ||
        airing_date == null ||
        rating == null ||
        director_id == null ||
        actors == null || actors.size() == 0 ||
        genres == null || genres.size() == 0)
        {
            model.addAttribute("error", "Not enough attributes, make sure all values are inputted, all of them are required");
            model.addAttribute("hasError", true);
            return "redirect:/add";
        }
        List<Person> actorsList = new LinkedList<>();
        for(Integer id: actors){
            Optional<Person> person = personService.findActorById(id);
            if(person.isEmpty()){
                model.addAttribute("error", "The actor with ID {" + id + "} was not found.");
                model.addAttribute("hasError", true);
                return "redirect:/add";
            }
            actorsList.add(person.get());
        }

        List<Genre> genreList = new LinkedList<>();
        for(Integer id: genres){
            Optional<Genre> genre = genreService.findById(id);
            if(genre.isEmpty()){
                model.addAttribute("error", "The genre with ID {" + id + "} was not found.");
                model.addAttribute("hasError", true);
                return "redirect:/add";
            }
            genreList.add(genre.get());
        }

        Optional<Person> directorOp = personService.findDirectorById(director_id);
        if(directorOp.isEmpty()){
            model.addAttribute("error", "The director with ID {" + director_id + "} was not found.");
            model.addAttribute("hasError", true);
            return "redirect:/add";
        }

        Person director = directorOp.get();

        Movie movie = new Movie(title, description, image_url, airing_date,
                    rating, director, actorsList, genreList);

        movieService.save(movie);

        return "redirect:/movies";
    }

    @PostMapping("/edit/confirm")
    public String editMoviePost(
                                @RequestParam Integer movie_id,
                                @RequestParam String title,
                               @RequestParam String description,
                               @RequestParam String image_url,
                               @RequestParam Date airing_date,
                               @RequestParam Float rating,
                               @RequestParam Integer director_id,
                               @RequestParam List<Integer> actors,
                               @RequestParam List<Integer> genres,
                               Model model){
        if(
                movie_id == null ||
                title == null || title.isEmpty() ||
                description == null || description.isEmpty() ||
                image_url == null || image_url.isEmpty() ||
                airing_date == null ||
                rating == null ||
                director_id == null ||
                actors == null || actors.size() == 0 ||
                genres == null || genres.size() == 0)
        {
            model.addAttribute("error", "Not enough attributes, make sure all values are inputted, all of them are required");
            model.addAttribute("hasError", true);
            return "redirect:/edit";
        }

        Optional<Movie> movieOptional = movieService.findById(movie_id);
        if(movieOptional.isEmpty()){
            model.addAttribute("error", "The movie with ID {" + movie_id + "} was not found.");
            model.addAttribute("hasError", true);
            return "redirect:/edit";
        }
        Movie movie = movieOptional.get();

        List<Person> actorsList = new LinkedList<>();
        for(Integer id: actors){
            Optional<Person> person = personService.findActorById(id);
            if(person.isEmpty()){
                model.addAttribute("error", "The actor with ID {" + id + "} was not found.");
                model.addAttribute("hasError", true);
                return "redirect:/edit";
            }
            actorsList.add(person.get());
        }

        List<Genre> genreList = new LinkedList<>();
        for(Integer id: genres){
            Optional<Genre> genre = genreService.findById(id);
            if(genre.isEmpty()){
                model.addAttribute("error", "The genre with ID {" + id + "} was not found.");
                model.addAttribute("hasError", true);
                return "redirect:/edit";
            }
            genreList.add(genre.get());
        }

        Optional<Person> directorOp = personService.findDirectorById(director_id);
        if(directorOp.isEmpty()){
            model.addAttribute("error", "The director with ID {" + director_id + "} was not found.");
            model.addAttribute("hasError", true);
            return "redirect:/edit";
        }

        Person director = directorOp.get();

        movieService.deleteById(movie_id);

        movie.setActors(actorsList);
        movie.setDirector(director);
        movie.setGenres(genreList);
        movie.setTitle(title);
        movie.setDescription(description);
        movie.setAiring_date(airing_date);
        movie.setImage_url(image_url);
        movie.setImdb_rating(rating);

        movieService.save(movie);

        return "redirect:/movies";
    }

    @GetMapping("/{id}/edit")
    public String editMovie(@PathVariable Integer id, Model model){
        Movie movie = movieService.findById(id).orElseThrow(() -> new MovieIdNotFoundException(id));
        model.addAttribute("directors", personService.findAllDirectors());
        model.addAttribute("actors", personService.findAllActors());
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("movie", movie);
        model.addAttribute("contentTemplate", "moviesEdit");
        return "template";
    }
}

package com.wediscussmovies.project.web.controller;

import com.wediscussmovies.project.model.*;
import com.wediscussmovies.project.model.enumerations.DiscussionType;
import com.wediscussmovies.project.service.DiscussionService;
import com.wediscussmovies.project.service.MovieService;
import com.wediscussmovies.project.service.PersonService;
import com.wediscussmovies.project.service.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/discussions")
public class DiscussionsController {
    private final DiscussionService discussionService;
    private final ReplyService replyService;
    private final MovieService movieService;
    private final PersonService personService;
    public DiscussionsController(DiscussionService discussionService, ReplyService replyService, MovieService movieService, PersonService personService) {
        this.discussionService = discussionService;
        this.replyService = replyService;
        this.movieService = movieService;
        this.personService = personService;
    }

    @GetMapping("/")
    public String getDiscussions(@RequestParam(required = false) String titleSearch,
                                    Model model){
        List<Discussion> discussions = discussionService.listAll();
        if(titleSearch != null && !titleSearch.isEmpty()){
            discussions = discussionService.listAllByTitle(titleSearch);
        }
        model.addAttribute("discussions", discussions);
        model.addAttribute("contentTemplate", "discussionsList");
        return "template";
    }

    @GetMapping("/{id}")
    public String getDiscussion(
            @PathVariable Integer id,
            Model model){
        Optional<Discussion> discussion = discussionService.findById(id);
        if(discussion.isEmpty())
            return "redirect:/discussions";
        model.addAttribute("discussion", discussion);
        model.addAttribute("contentTemplate", "discussionsDiscussion");
        return "template";
    }

    @GetMapping("/{id}/reply")
    public String getReplyToDiscussion(
            @PathVariable Integer id,
            Model model){
        Optional<Discussion> discussion = discussionService.findById(id);
        if(discussion.isEmpty())
            return "redirect:/discussions";
        model.addAttribute("discussion", discussion);
        model.addAttribute("contentTemplate", "discussionsReply");
        return "template";
    }
    @PostMapping("/{id}/reply/confirm")
    public String getReplyToDiscussionConfirm(
            @PathVariable Integer id,
            @RequestParam String text,
            HttpServletRequest request){
        Optional<Discussion> discussion = discussionService.findById(id);
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return "redirect:/login";
        }
        Date date = Date.valueOf(LocalDate.now());
        if(discussion.isEmpty())
            return "redirect:/discussions";
        Reply reply = new Reply(discussion.get(), user, date, text);
        replyService.save(reply);
        return "redirect:/discussions/"+id;
    }

    @GetMapping("/movies/add/{id}")
    public String getAddDiscussionForMovie(Model model,
                                           @PathVariable Integer id,
                                           HttpServletRequest request){
        model.addAttribute("contentTemplate", "discussionsAdd");
        request.setAttribute("movieId", id);
        return "template";
    }

    @PostMapping("/movies/add/confirm")
    public String getAddDiscussionMovieConfirm(Model model,
                                               HttpServletRequest request,
                                               @RequestParam String title,
                                               @RequestParam String text){
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return "redirect:/login";
        }
        Long movie_id = (Long) request.getSession().getAttribute("movieId");
        request.getSession().setAttribute("movieId", null);
        Optional<Movie> movieOp = movieService.findById(movie_id);
        if(movieOp.isEmpty())
            return "redirect:/movies";
        Discussion discussion = new Discussion(DiscussionType.M,text, title, Date.valueOf(LocalDate.now()),user,movieOp.get(),null,new ArrayList<>());
        discussionService.save(discussion);
        return "redirect:/discussions";
    }


    @GetMapping("/persons/add/{id}")
    public String getAddDiscussionForPerson(Model model,
                                           @PathVariable Integer id,
                                           HttpServletRequest request){
        model.addAttribute("contentTemplate", "discussionsAdd");
        request.setAttribute("personId", id);
        return "template";
    }

    @PostMapping("/persons/add/confirm")
    public String getAddDiscussionForPersonConfirm(Model model,
                                               HttpServletRequest request,
                                               @RequestParam String title,
                                               @RequestParam String text){
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return "redirect:/login";
        }
        Integer person_id = (Integer) request.getSession().getAttribute("personId");
        Optional<Person> personOp = personService.findById(person_id);
        request.getSession().setAttribute("personId", null);
        if(personOp.isEmpty())
            return "redirect:/discussions";
        Discussion discussion = new Discussion(DiscussionType.P,title, text,Date.valueOf(LocalDate.now()),user,null,personOp.get(),new ArrayList<>());
        discussionService.save(discussion);
        return "redirect:/discussions";
    }


}

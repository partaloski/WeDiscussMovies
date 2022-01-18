package com.wediscussmovies.project.web.controller;

import com.wediscussmovies.project.model.*;
import com.wediscussmovies.project.model.enumerations.PersonType;
import com.wediscussmovies.project.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class PersonsController {
    private final PersonService personSerivce;

    public PersonsController(PersonService personSerivce) {
        this.personSerivce = personSerivce;
    }

    @GetMapping("/actors")
    public String getActorsPage(Model model, @RequestParam(required = false) String nameAndSurname){
        List<Person> actors = personSerivce.findAllActors();
        if(nameAndSurname != null && !nameAndSurname.isEmpty()){
            String [] parts = nameAndSurname.split(" ");
            String name = parts[0];
            String surname = "";
            if(parts.length > 1)
                surname = parts[1];
            List<Person> actorsByName = personSerivce.findActorsByNameLike("%"+name+"%");
            if(!surname.isEmpty()){
                List<Person> actorsBySurname = personSerivce.findActorsBySurnameLike("%"+surname+"%");
                for(Person p: actorsBySurname){
                    boolean add = true;
                    for(Person a: actorsByName){
                        if(a.getPersonId() == p.getPersonId()){
                            add=false;
                            break;
                        }
                    }
                    if(!add)
                        continue;
                    actorsByName.add(p);
                }
            }
            actors = actorsByName;
        }
       // actors.sort(Person.personComparatorByNameSurname);
        model.addAttribute("actors", actors);
        model.addAttribute("contentTemplate", "actorsList");
        return "template";
    }

    @GetMapping("/directors")
    public String getDirectorsPage(Model model, @RequestParam(required = false) String nameAndSurname){
        List<Person> directors = personSerivce.findAllDirectors();
        if(nameAndSurname != null && !nameAndSurname.isEmpty()){
            String [] parts = nameAndSurname.split(" ");
            String name = parts[0];
            String surname = "";
            if(parts.length > 1)
                surname = parts[1];
            List<Person> directorsByName = personSerivce.findDirectorsByNameLike("%"+name+"%");
            if(!surname.isEmpty()){
                List<Person> directorsBySurname = personSerivce.findDirectorsBySurnameLike("%"+surname+"%");
                for(Person p: directorsBySurname){
                    boolean add = true;
                    for(Person a: directorsByName){
                        if(a.getPersonId() == p.getPersonId()){
                            add=false;
                            break;
                        }
                    }
                    if(!add)
                        continue;
                    directorsByName.add(p);
                }
            }
            directors = directorsByName;
        }
     //   directors.sort(Person.personComparatorByNameSurname);
        model.addAttribute("directors", directors);
        model.addAttribute("contentTemplate", "directorsList");
        return "template";
    }

    @GetMapping("/persons/add")
    public String getPersonsAddPage(Model model){
        PersonType [] types = PersonType.values();
        model.addAttribute("types", types);
        model.addAttribute("contentTemplate", "personsAdd");
        return "template";
    }

    @PostMapping("/persons/add/confirm")
    public String confirmPersonsAdd(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam Character type,
            @RequestParam Date date_of_birth,
            @RequestParam String image_url,
            @RequestParam String description){
        Person person = new Person(name, surname, type, date_of_birth, image_url, description);
        if(personSerivce.save(person)){
            String toWhere = "actors";
            //if(type == PersonType.D)
                toWhere = "directors";
            return "redirect:/"+toWhere;
        }
        else{
            return "redirect:/persons/add";
        }
    }

}

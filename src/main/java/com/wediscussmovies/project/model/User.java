package com.wediscussmovies.project.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private Long userId;

    private String username;

    private String name;

    private String surname;

    private String email;

    private String password;

    @ManyToMany
    private List<Movie> movies;




    public User(String username, String name, String surname, String email, String password) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public User() {
    }
}

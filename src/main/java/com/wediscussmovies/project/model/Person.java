package com.wediscussmovies.project.model;

import com.wediscussmovies.project.model.enumerations.PersonType;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "persons", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
@Data
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "person_id")
    private Long personId;

    private String name;

    private String surname;

    @Enumerated
    private PersonType type;

    @Column(name = "date_of_birth")
    private Date birthDate;

    @Column(name = "image_url")
    private String imageUrl;

    private String description;



    public Person() {
    }

    public Person(String name, String surname, PersonType type, Date date_of_birth, String image_url, String description) {
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.birthDate = date_of_birth;
        this.imageUrl = image_url;
        this.description = description;
    }
}

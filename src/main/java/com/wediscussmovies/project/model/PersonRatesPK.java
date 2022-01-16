package com.wediscussmovies.project.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PersonRatesPK implements Serializable {

    @Id
    @Column(name = "person_id")
    private Long personId;
    @Id
    @Column(name = "user_id")
    private Long userId;


}

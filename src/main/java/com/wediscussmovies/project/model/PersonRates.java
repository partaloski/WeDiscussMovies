package com.wediscussmovies.project.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "person_rates", schema = "project", catalog = "db_202122z_va_prj_wediscussmovies")
@IdClass(PersonRatesPK.class)
@Data
public class PersonRates {
    @Id
    @Column(name = "person_id")
    private Long personId;

    @Id
    @Column(name = "user_id")
    private Long userId;

    private String reason;

    @Column(name = "stars_rated")
    private int stars;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false,insertable = false, updatable = false)
    private Person person;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false,insertable = false, updatable = false)
    private User user;

    public PersonRates(Long person_id, Long user_id, String reason, int stars_rated) {
        this.personId = person_id;
        this.userId = user_id;
        this.reason = reason;
        this.stars = stars_rated;
    }

    public PersonRates() {
    }
}

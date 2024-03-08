package com.tiwilli.dslearn.dto;

import com.tiwilli.dslearn.entities.Offer;

import java.time.Instant;

public class OfferDTO {

    private Long id;
    private String edition;
    private Instant startMoment;
    private Instant endMoment;
    private Long courseId;

    public OfferDTO(Long id, String edition, Instant startMoment, Instant endMoment, Long courseId) {
        this.id = id;
        this.edition = edition;
        this.startMoment = startMoment;
        this.endMoment = endMoment;
        this.courseId = courseId;
    }

    public OfferDTO(Offer entity) {
        id = entity.getId();
        edition = entity.getEdition();
        startMoment = entity.getStartMoment();
        endMoment = entity.getEndMoment();
        courseId = entity.getCourse().getId();
    }

    public Long getId() {
        return id;
    }

    public String getEdition() {
        return edition;
    }

    public Instant getStartMoment() {
        return startMoment;
    }

    public Instant getEndMoment() {
        return endMoment;
    }

    public Long getCourseId() {
        return courseId;
    }
}

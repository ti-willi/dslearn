package com.tiwilli.dslearn.dto;

import com.tiwilli.dslearn.entities.Offer;

import java.time.Instant;

public class OfferDTO {

    private Long id;
    private String edition;
    private Instant startMoment;
    private Instant endMoment;

    public OfferDTO(Long id, String edition, Instant startMoment, Instant endMoment) {
        this.id = id;
        this.edition = edition;
        this.startMoment = startMoment;
        this.endMoment = endMoment;
    }

    public OfferDTO(Offer entity) {
        id = entity.getId();
        edition = entity.getEdition();
        startMoment = entity.getStartMoment();
        endMoment = entity.getEndMoment();
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
}

package com.tiwilli.dslearn.dto;

import com.tiwilli.dslearn.entities.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDTO {

    private Long id;
    private String name;
    private String imgUri;
    private String imgGrayUri;

    private List<OfferDTO> offers = new ArrayList<>();

    public CourseDTO(Long id, String name, String imgUri, String imgGrayUri) {
        this.id = id;
        this.name = name;
        this.imgUri = imgUri;
        this.imgGrayUri = imgGrayUri;
    }

    public CourseDTO(Course entity) {
        id = entity.getId();
        name = entity.getName();
        imgUri = entity.getImgUri();
        imgGrayUri = entity.getImgGrayUri();
        entity.getOffers().forEach(offer -> this.offers.add(new OfferDTO(offer)));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgUri() {
        return imgUri;
    }

    public String getImgGrayUri() {
        return imgGrayUri;
    }

    public List<OfferDTO> getOffers() {
        return offers;
    }
}

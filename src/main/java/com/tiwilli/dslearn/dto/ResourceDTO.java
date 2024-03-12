package com.tiwilli.dslearn.dto;

import com.tiwilli.dslearn.entities.Resource;
import com.tiwilli.dslearn.entities.enums.ResourceType;

public class ResourceDTO {

    private Long id;
    private String title;
    private String description;
    private Integer position;
    private String imgUri;
    private ResourceType type;
    private Long offerId;

    public ResourceDTO(Long id, String title, String description, Integer position, String imgUri, ResourceType type, Long offerId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.position = position;
        this.imgUri = imgUri;
        this.type = type;
        this.offerId = offerId;
    }

    public ResourceDTO(Resource entity) {
        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        position = entity.getPosition();
        imgUri = entity.getImgUri();
        type = entity.getType();
        offerId = entity.getOffer().getId();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPosition() {
        return position;
    }

    public String getImgUri() {
        return imgUri;
    }

    public ResourceType getType() {
        return type;
    }

    public Long getOfferId() {
        return offerId;
    }
}

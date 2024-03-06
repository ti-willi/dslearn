package com.tiwilli.dslearn.dto;

import com.tiwilli.dslearn.entities.Notification;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;

public class NotificationDTO {

    private Long id;
    @NotBlank(message = "Campo requerido")
    private String text;
    private Instant moment;
    private boolean read;
    private String route;

    private UserDTO user;

    public NotificationDTO(Long id, String text, Instant moment, boolean read, String route, UserDTO user) {
        this.id = id;
        this.text = text;
        this.moment = moment;
        this.read = read;
        this.route = route;
        this.user = user;
    }

    public NotificationDTO(Notification entity) {
        id = entity.getId();
        text = entity.getText();
        moment = entity.getMoment();
        read = entity.isRead();
        route = entity.getRoute();
        user = new UserDTO(entity.getUser());
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Instant getMoment() {
        return moment;
    }

    public boolean isRead() {
        return read;
    }

    public String getRoute() {
        return route;
    }

    public UserDTO getUser() {
        return user;
    }
}

package com.tiwilli.dslearn.dto;

import com.tiwilli.dslearn.entities.Enrollment;

import java.time.Instant;

public class EnrollmentDTO {

    private Long offerId;
    private Instant enrollMoment;
    private Instant refundMoment;
    private boolean available;
    private boolean onlyUpdate;

    public EnrollmentDTO(Long offerId, Instant enrollMoment, Instant refundMoment, boolean available, boolean onlyUpdate) {
        this.offerId = offerId;
        this.enrollMoment = enrollMoment;
        this.refundMoment = refundMoment;
        this.available = available;
        this.onlyUpdate = onlyUpdate;
    }

    public EnrollmentDTO(Enrollment entity) {
        offerId = entity.getOffer().getId();
        enrollMoment = entity.getEnrollMoment();
        refundMoment = entity.getRefundMoment();
        available = entity.isAvailable();
        onlyUpdate = entity.isOnlyUpdate();
    }

    public Long getOfferId() {
        return offerId;
    }

    public Instant getEnrollMoment() {
        return enrollMoment;
    }

    public Instant getRefundMoment() {
        return refundMoment;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean isOnlyUpdate() {
        return onlyUpdate;
    }
}

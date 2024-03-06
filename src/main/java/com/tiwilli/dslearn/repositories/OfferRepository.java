package com.tiwilli.dslearn.repositories;

import com.tiwilli.dslearn.entities.Notification;
import com.tiwilli.dslearn.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}

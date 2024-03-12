package com.tiwilli.dslearn.repositories;

import com.tiwilli.dslearn.dto.OfferDTO;
import com.tiwilli.dslearn.entities.Notification;
import com.tiwilli.dslearn.entities.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}

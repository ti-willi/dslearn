package com.tiwilli.dslearn.repositories;

import com.tiwilli.dslearn.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}

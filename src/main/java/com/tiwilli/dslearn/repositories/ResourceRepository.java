package com.tiwilli.dslearn.repositories;

import com.tiwilli.dslearn.entities.Course;
import com.tiwilli.dslearn.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}

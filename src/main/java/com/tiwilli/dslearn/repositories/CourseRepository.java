package com.tiwilli.dslearn.repositories;

import com.tiwilli.dslearn.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

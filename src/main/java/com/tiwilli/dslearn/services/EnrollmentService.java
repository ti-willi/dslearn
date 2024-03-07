package com.tiwilli.dslearn.services;

import com.tiwilli.dslearn.dto.EnrollmentDTO;
import com.tiwilli.dslearn.dto.UserDTO;
import com.tiwilli.dslearn.entities.Enrollment;
import com.tiwilli.dslearn.entities.Offer;
import com.tiwilli.dslearn.entities.User;
import com.tiwilli.dslearn.repositories.EnrollmentRepository;
import com.tiwilli.dslearn.repositories.OfferRepository;
import com.tiwilli.dslearn.repositories.UserRepository;
import com.tiwilli.dslearn.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public List<EnrollmentDTO> findByUser() {
        UserDTO currentUser = userService.getMe();
        Long userId = currentUser.getId();

        List<Enrollment> result = repository.searchByUser(userId);
        return result.stream().map(EnrollmentDTO::new).collect(Collectors.toList());
    }

    public void enrollStudentToCourse(Long offerId) {
        UserDTO currentUser = userService.getMe();
        Long studentId = currentUser.getId();
        User user = userRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Offer offer = offerRepository.findById(offerId).orElseThrow(() -> new ResourceNotFoundException("Offer not found"));
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(user);
        enrollment.setOffer(offer);
        enrollment.setAvailable(true);
        enrollment.setEnrollMoment(Instant.now());

        repository.save(enrollment);
    }

}

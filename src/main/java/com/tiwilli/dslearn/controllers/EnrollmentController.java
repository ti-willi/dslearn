package com.tiwilli.dslearn.controllers;

import com.tiwilli.dslearn.dto.EnrollmentDTO;
import com.tiwilli.dslearn.dto.OfferDTO;
import com.tiwilli.dslearn.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/my-enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService service;

    @PreAuthorize("hasAnyRole('ROLE_STUDENT')")
    @GetMapping("/courses")
    public ResponseEntity<List<OfferDTO>> findAll() {
        List<OfferDTO> dto = service.findMyEnrollments();
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT')")
    @PostMapping("/enroll")
    public ResponseEntity<String> enrollStudentToOffer(@RequestParam Long offerId) {
        service.enrollStudentToCourse(offerId);
        return ResponseEntity.ok("Matricula realizada com sucesso");
    }

}

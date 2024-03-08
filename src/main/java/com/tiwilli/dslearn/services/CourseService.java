package com.tiwilli.dslearn.services;

import com.tiwilli.dslearn.dto.CourseDTO;
import com.tiwilli.dslearn.entities.Course;
import com.tiwilli.dslearn.repositories.EnrollmentRepository;
import com.tiwilli.dslearn.repositories.CourseRepository;
import com.tiwilli.dslearn.services.exceptions.DatabaseException;
import com.tiwilli.dslearn.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public CourseDTO findById(Long id) {
        Course Course = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")
        );
        return new CourseDTO(Course);
    }

    @Transactional(readOnly = true)
    public Page<CourseDTO> findAll(Pageable pageable) {
        Page<Course> result = repository.findAll(pageable);
        return result.map(CourseDTO::new);
    }

    @Transactional
    public CourseDTO insert(CourseDTO dto) {
        Course entity = new Course();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new CourseDTO(entity);
    }

    @Transactional
    public CourseDTO update(Long id, CourseDTO dto) {
        try {
            Course entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new CourseDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }


    private void copyDtoToEntity(CourseDTO dto, Course entity) {
        entity.setName(dto.getName());
        entity.setImgUri(dto.getImgUri());
        entity.setImgGrayUri(dto.getImgGrayUri());
    }

}

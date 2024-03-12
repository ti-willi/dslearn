package com.tiwilli.dslearn.services;

import com.tiwilli.dslearn.dto.ResourceDTO;
import com.tiwilli.dslearn.entities.Course;
import com.tiwilli.dslearn.entities.Offer;
import com.tiwilli.dslearn.entities.Resource;
import com.tiwilli.dslearn.repositories.CourseRepository;
import com.tiwilli.dslearn.repositories.EnrollmentRepository;
import com.tiwilli.dslearn.repositories.OfferRepository;
import com.tiwilli.dslearn.repositories.ResourceRepository;
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
public class ResourceService {

    @Autowired
    private ResourceRepository repository;

    @Autowired
    private OfferRepository offerRepository;

    @Transactional(readOnly = true)
    public ResourceDTO findById(Long id) {
        Resource Resource = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")
        );
        return new ResourceDTO(Resource);
    }

    @Transactional(readOnly = true)
    public Page<ResourceDTO> findAll(Pageable pageable) {
        Page<Resource> result = repository.findAll(pageable);
        return result.map(ResourceDTO::new);
    }

    @Transactional
    public ResourceDTO insert(ResourceDTO dto) {
        Resource entity = new Resource();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ResourceDTO(entity);
    }

    @Transactional
    public ResourceDTO update(Long id, ResourceDTO dto) {
        try {
            Resource entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ResourceDTO(entity);
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


    private void copyDtoToEntity(ResourceDTO dto, Resource entity) {
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setPosition(dto.getPosition());
        entity.setImgUri(dto.getImgUri());
        entity.setType(dto.getType());

        Offer offer = offerRepository.findById(dto.getOfferId()).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));

        entity.setOffer(offer);
    }

}

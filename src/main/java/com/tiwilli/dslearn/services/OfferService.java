package com.tiwilli.dslearn.services;

import com.tiwilli.dslearn.dto.OfferDTO;
import com.tiwilli.dslearn.entities.Offer;
import com.tiwilli.dslearn.repositories.OfferRepository;
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
public class OfferService {

    @Autowired
    private OfferRepository repository;

    @Transactional(readOnly = true)
    public OfferDTO findById(Long id) {
        Offer Offer = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")
        );
        return new OfferDTO(Offer);
    }

    @Transactional(readOnly = true)
    public Page<OfferDTO> findAll(Pageable pageable) {
        Page<Offer> result = repository.findAll(pageable);
        return result.map(OfferDTO::new);
    }

    @Transactional
    public OfferDTO insert(OfferDTO dto) {
        Offer entity = new Offer();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new OfferDTO(entity);
    }

    @Transactional
    public OfferDTO update(Long id, OfferDTO dto) {
        try {
            Offer entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new OfferDTO(entity);
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

    private void copyDtoToEntity(OfferDTO dto, Offer entity) {
        entity.setEdition(dto.getEdition());
        entity.setStartMoment(dto.getStartMoment());
        entity.setEndMoment(dto.getEndMoment());
    }

}

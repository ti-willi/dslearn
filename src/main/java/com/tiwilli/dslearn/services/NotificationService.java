package com.tiwilli.dslearn.services;

import com.tiwilli.dslearn.dto.NotificationDTO;
import com.tiwilli.dslearn.entities.Notification;
import com.tiwilli.dslearn.repositories.NotificationRepository;
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
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    @Transactional(readOnly = true)
    public NotificationDTO findById(Long id) {
        Notification notification = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")
        );
        return new NotificationDTO(notification);
    }

    @Transactional(readOnly = true)
    public Page<NotificationDTO> findAll(Pageable pageable) {
        Page<Notification> result = repository.findAll(pageable);
        return result.map(NotificationDTO::new);
    }

    @Transactional
    public NotificationDTO insert(NotificationDTO dto) {
        Notification entity = new Notification();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new NotificationDTO(entity);
    }

    @Transactional
    public NotificationDTO update(Long id, NotificationDTO dto) {
        try {
            Notification entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new NotificationDTO(entity);
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

    private void copyDtoToEntity(NotificationDTO dto, Notification entity) {
        entity.setText(dto.getText());
        entity.setMoment(dto.getMoment());
        entity.setRead(dto.isRead());
        entity.setRoute(dto.getRoute());
    }

}

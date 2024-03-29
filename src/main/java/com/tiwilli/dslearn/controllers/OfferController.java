package com.tiwilli.dslearn.controllers;

import com.tiwilli.dslearn.dto.OfferDTO;
import com.tiwilli.dslearn.services.OfferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/offers")
public class OfferController {

    @Autowired
    private OfferService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OfferDTO> findById(@PathVariable Long id) {
        OfferDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<OfferDTO>> findAll(Pageable pageable) {
        Page<OfferDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<OfferDTO> insert(@Valid @RequestBody OfferDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OfferDTO> update(@PathVariable Long id, @Valid @RequestBody OfferDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}

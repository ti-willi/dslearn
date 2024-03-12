package com.tiwilli.dslearn.controllers;

import com.tiwilli.dslearn.dto.ResourceDTO;
import com.tiwilli.dslearn.services.ResourceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/resources")
public class ResourceController {

    @Autowired
    private ResourceService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResourceDTO> findById(@PathVariable Long id) {
        ResourceDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ResourceDTO>> findAll(Pageable pageable) {
        Page<ResourceDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ResourceDTO> insert(@Valid @RequestBody ResourceDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResourceDTO> update(@PathVariable Long id, @Valid @RequestBody ResourceDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

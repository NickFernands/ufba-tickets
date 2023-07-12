package com.ufbatickets.project.locais.controller;

import com.ufbatickets.project.locais.model.LocaisModel;
import com.ufbatickets.project.locais.repository.LocaisRepository;
import com.ufbatickets.project.utils.EndpointUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/locais")
public class LocaisController {

    LocaisRepository locaisRepository;
    EndpointUtils endpointUtils;

    @Autowired
    public LocaisController(LocaisRepository locaisRepository,  EndpointUtils endpointUtils ){
        this.locaisRepository = locaisRepository;
        this.endpointUtils = endpointUtils;
    }

    @GetMapping()
    public ResponseEntity<?> ListLocals() {
        return endpointUtils.returnObjectOrNotFound(locaisRepository.findAll());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getLocalById(@PathVariable long id) {
        return endpointUtils.returnObjectOrNotFound(locaisRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> criarLocal(@Valid @RequestBody LocaisModel local) {

        locaisRepository.save(local);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PatchMapping(path = "{id}")
    public ResponseEntity<?> AtualizarLocal(@PathVariable("id") Long id, @RequestBody LocaisModel local) {

        try {
            if (!locaisRepository.existsById(id)) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            local.setIdLocais(id);

            local = locaisRepository.save(local);

            return ResponseEntity.ok(local);

        } catch (UnsupportedOperationException e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> DeletarLocais(@PathVariable("id") Long id){

        if (!locaisRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        locaisRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

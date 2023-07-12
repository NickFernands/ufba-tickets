package com.ufbatickets.project.avaliacoes.controller;

import com.ufbatickets.project.avaliacoes.repository.AvaliacoesRepository;
import com.ufbatickets.project.avaliacoes.model.AvaliacoesModel;
import com.ufbatickets.project.utils.EndpointUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/eventos/avaliacoes")
public class AvaliacoesController {

    AvaliacoesRepository avaliacoesRepository;
    EndpointUtils endpointUtils;

    @Autowired
    public AvaliacoesController(AvaliacoesRepository avaliacoesRepository,  EndpointUtils endpointUtils ){
        this.avaliacoesRepository = avaliacoesRepository;
        this.endpointUtils = endpointUtils;
    }

    @GetMapping()
    public ResponseEntity<?> ListRates() {
        return endpointUtils.returnObjectOrNotFound(avaliacoesRepository.findAll());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> geRatesById(@PathVariable long id) {
        return endpointUtils.returnObjectOrNotFound(avaliacoesRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createRate(@Valid @RequestBody AvaliacoesModel avaliacao) {

        avaliacoesRepository.save(avaliacao);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> DeleteEvent(@PathVariable("id") Long id){

        if (!avaliacoesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        avaliacoesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


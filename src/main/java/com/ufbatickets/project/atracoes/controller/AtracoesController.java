package com.ufbatickets.project.atracoes.controller;

import com.ufbatickets.project.atracoes.model.AtracoesModel;
import com.ufbatickets.project.atracoes.repository.AtracoesRepository;
import com.ufbatickets.project.utils.EndpointUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin
@RestController
@RequestMapping("/eventos/atracoes")
public class AtracoesController {

    AtracoesRepository atracoesRepository;
    EndpointUtils endpointUtils;

    @Autowired
    public AtracoesController(AtracoesRepository atracoesRepository, EndpointUtils endpointUtils ){
        this.atracoesRepository = atracoesRepository;
        this.endpointUtils = endpointUtils;
    }

    @GetMapping()
    public ResponseEntity<?> ListAtracoes() {
        return endpointUtils.returnObjectOrNotFound(atracoesRepository.findAll());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getAtracaoById(@PathVariable long id) {
        return endpointUtils.returnObjectOrNotFound(atracoesRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> criarAtracao(@Valid @RequestBody AtracoesModel atracao) {

        atracoesRepository.save(atracao);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PatchMapping(path = "{id}")
    public ResponseEntity<?> AtualizarAtracao(@PathVariable("id") Long id, @RequestBody AtracoesModel atracao) {

        try{

            if (!atracoesRepository.existsById(id)) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            atracao.setIdAtracoes(id);
            atracao = atracoesRepository.save(atracao);
            return ResponseEntity.ok(atracao);

        } catch (UnsupportedOperationException e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping(path = {"id"})
    public ResponseEntity<?> DeletarAtracao(@PathVariable("id") Long id){

        if (!atracoesRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        atracoesRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

package com.ufbatickets.project.usuários.controller;

import com.ufbatickets.project.usuários.model.UsuariosModel;
import com.ufbatickets.project.usuários.repository.UsuariosRepository;
import com.ufbatickets.project.usuários.request.LoginRequest;
import com.ufbatickets.project.utils.EndpointUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    EndpointUtils endpointUtils;

    @GetMapping
    public List<UsuariosModel> ChecagemDeUsuario(){
        return this.usuariosRepository.findAll();
    }

    @GetMapping("/{Id}")
    public UsuariosModel ChamarUsuario(@PathVariable("Id") Long Id){
        return this.usuariosRepository.findById(Id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest ){

        return endpointUtils.returnObjectOrNotFound(this.usuariosRepository.findByLoginAndSenha(loginRequest.getLogin(), loginRequest.getSenha()));


    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuariosModel CriarUsuario(@Valid @RequestBody UsuariosModel user){
        return this.usuariosRepository.save(user);
    }

    @PatchMapping("/{Id}")
    public ResponseEntity<UsuariosModel> AtualizarUsuario(@PathVariable("Id") Long Id, @RequestBody UsuariosModel user) {

        try {

            if (!usuariosRepository.existsById(Id)) {
                return ResponseEntity.notFound().build();
            }

            user.setUserId(Id);

            user=usuariosRepository.save(user);

            return ResponseEntity.ok(user);

        } catch (UnsupportedOperationException e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<?> DeletarUsuario(@PathVariable("Id") Long Id){

        if (!usuariosRepository.existsById(Id)) {
            return ResponseEntity.notFound().build();
        }

        usuariosRepository.deleteById(Id);
        return ResponseEntity.noContent().build();
    }
}

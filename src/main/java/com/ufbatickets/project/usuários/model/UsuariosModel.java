package com.ufbatickets.project.usuários.model;

import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuarios")
public class UsuariosModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull(message = "Campo nao pode estar vazio")
    @NotEmpty(message = "Campo nao pode estar vazio")
    @Length(max = 150,message = "Quantidade de caracteres excedida")
    private String nome;

    @NotNull(message = "Campo nao pode estar vazio")
    @NotEmpty(message = "Campo nao pode estar vazio")
    @Email(message = "email inválido")
    private String email;

    @NotNull(message = "Campo nao pode estar vazio")
    @NotEmpty(message = "Campo nao pode estar vazio")
    private String login;

    @NotNull(message = "Campo nao pode estar vazio")
    @NotEmpty(message = "Campo nao pode estar vazio")
    private String senha;

    private Boolean verificada;

    @NotNull(message = "Campo nao pode estar vazio")
    @NotEmpty(message = "Campo nao pode estar vazio")
    private String estado;

    @NotNull(message = "Campo nao pode estar vazio")
    @NotEmpty(message = "Campo nao pode estar vazio")
    private String cidade;

    @NotNull(message = "Campo nao pode estar vazio")
    @NotEmpty(message = "Campo nao pode estar vazio")
    private String bairro;
}


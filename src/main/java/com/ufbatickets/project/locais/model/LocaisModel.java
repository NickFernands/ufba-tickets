package com.ufbatickets.project.locais.model;

import com.ufbatickets.project.usuários.model.UsuariosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "Locais")
public class LocaisModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocais;

    @NotNull(message = "Campo nao pode estar vazio")
    @Length(max = 255, message = "Quantidade de caracteres não permitida")
    @Column(name = "nome")
    private String nome;

    @NotNull(message = "Campo nao pode estar vazio")
    @Length(max = 255, message = "Quantidade de caracteres não permitida")
    @Column(name = "categoria")
    private String categoria;

    @NotNull(message = "Campo nao pode estar vazio")
    @Column(name = "endereco")
    private String endereco;

    @ManyToOne(optional = false)
    private UsuariosModel usuario;

}

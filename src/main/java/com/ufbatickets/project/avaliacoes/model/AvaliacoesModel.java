package com.ufbatickets.project.avaliacoes.model;

import com.ufbatickets.project.avaliacoes.EnumNotas;
import com.ufbatickets.project.eventos.model.EventosModel;
import com.ufbatickets.project.usuários.model.UsuariosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "Avaliacoes")
public class AvaliacoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvaliacoes;

    @NotNull(message = "Campo nao pode estar vazio")
    @Column(columnDefinition = "text", name = "avaliacao")
    private String avaliacao;

    @Column(name = "nota")
    private EnumNotas nota;

    @ManyToOne(optional = false)
    private UsuariosModel usuario;

    @ManyToOne(optional = false)
    private EventosModel evento;


}

package com.ufbatickets.project.atracoes.model;

import com.ufbatickets.project.eventos.model.EventosModel;
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
@Table(name="Atracoes")
public class AtracoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAtracoes;

    @NotNull(message = "Campo nao pode estar vazio")
    @Length(max = 255, message = "Quantidade de caracteres não permitida")
    @Column(name = "nome")
    private String nome;

    @NotNull(message = "Campo nao pode estar vazio")
    @Column(columnDefinition = "TIME NOT NULL" ,name = "horario")
    private String horario;

    @NotNull(message = "Campo nao pode estar vazio")
    @Length(max = 100, message = "Quantidade de caracteres não permitida")
    @Column(name = "tipo")
    private String tipo;

    @ManyToOne(optional = false)
    private EventosModel eventos;

}

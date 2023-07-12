package com.ufbatickets.project.eventos.model;

import com.ufbatickets.project.usuários.model.UsuariosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data // cria getters e setters automáticos
@AllArgsConstructor // cria todos os métodos e construtores possíveis
@NoArgsConstructor // cria um construtor vazio
@Entity // mapeia a classe pra ser uma entidade no banco de dados
@Table(name= "Eventos") // dá o nome ao banco de dados
public class EventosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // vai ter um identificador pra cada elemento do banco e o identificador gera automaticamente
    private Long idEventos;

    @Column(name="nome")
    @NotNull(message = "Campo nao pode estar vazio")
    @Length(max = 200, min = 10, message = "Quantidade de caracteres não permitida")
    private String nome;

    @Column(name="endereco")
    @NotEmpty(message = "Campo nao pode ser vazio")
    @Length(max = 500, message = "Você ultrapassou a quantidade maxima de caracteres")
    private String endereco;

    @Column(name="categoria")
    @NotEmpty(message = "Campo nao pode ser vazio")
    @Length(max = 30, message = "Você ultrapassou a quantidade maxima de caracteres")
    private String categoria;

    @Column(columnDefinition = "time" ,name = "horario")
    @NotEmpty(message = "Campo nao pode ser vazio")
    private String horario;

    @Column(name= "preco")
    @DecimalMin("0.0")
    private Double preco;

    @ManyToOne(optional = false)
    private UsuariosModel userId;

}

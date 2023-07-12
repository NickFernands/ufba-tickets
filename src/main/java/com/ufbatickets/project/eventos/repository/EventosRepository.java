package com.ufbatickets.project.eventos.repository;

import com.ufbatickets.project.eventos.model.EventosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventosRepository extends JpaRepository<EventosModel, Long> {

    @Query("select e from EventosModel e where e.nome like concat('%', ?1, '%')")
    List<EventosModel> findEventoByNomeContains(String nome);


    @Query("select e from EventosModel e where e.categoria like concat('%', ?1, '%')")
    List<EventosModel> findEventoByCategoriaContains(String categoria);
}

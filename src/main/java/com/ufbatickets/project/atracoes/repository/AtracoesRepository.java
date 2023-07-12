package com.ufbatickets.project.atracoes.repository;

import com.ufbatickets.project.atracoes.model.AtracoesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtracoesRepository extends JpaRepository<AtracoesModel, Long> {
}

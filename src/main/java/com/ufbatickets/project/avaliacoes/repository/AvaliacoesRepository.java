package com.ufbatickets.project.avaliacoes.repository;

import com.ufbatickets.project.avaliacoes.model.AvaliacoesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacoesRepository extends JpaRepository<AvaliacoesModel,Long> {
}


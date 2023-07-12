package com.ufbatickets.project.locais.repository;

import com.ufbatickets.project.locais.model.LocaisModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LocaisRepository extends PagingAndSortingRepository<LocaisModel, Long> {
}

package com.backend.backend.repositories;

import com.backend.backend.models.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {
    // You can define custom query methods here if needed
}

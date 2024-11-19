package com.backend.backend.repositories;

import com.backend.backend.models.Etude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EtudeRepository extends JpaRepository<Etude, Long> {
}


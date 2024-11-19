package com.backend.backend.repositories;
import com.backend.backend.models.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EleveRepository extends JpaRepository<Eleve, Long> {
}


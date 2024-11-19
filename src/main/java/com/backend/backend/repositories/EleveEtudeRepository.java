package com.backend.backend.repositories;

import com.backend.backend.models.EleveEtude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleveEtudeRepository extends JpaRepository<EleveEtude, Long> {

}

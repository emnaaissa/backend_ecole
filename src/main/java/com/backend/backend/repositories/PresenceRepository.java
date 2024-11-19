package com.backend.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.backend.models.Presence;

@Repository
public interface PresenceRepository extends JpaRepository<Presence, Long> {
}


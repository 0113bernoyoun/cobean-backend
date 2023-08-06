package com.cobean.backend.roasters.repository;

import com.cobean.backend.roasters.domain.Roasters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoastersJpaRepository extends JpaRepository<Roasters, Long> {
}

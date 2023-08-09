package com.cobean.backend.roasters.repository;

import com.cobean.backend.roasters.domain.Roasters;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoastersJpaRepository extends JpaRepository<Roasters, Long> {

    List<Roasters> findAllByIsDeletedFalse();

    Optional<Roasters> findByIdAndIsDeletedFalse(Long id);
}

package com.cobean.backend.bean.repository;

import com.cobean.backend.bean.domain.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeanJpaRepository extends JpaRepository<Bean, Long> {
}

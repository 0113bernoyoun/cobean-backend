package com.cobean.backend.roasters.repository;

import com.cobean.backend.bean.domain.Bean;
import com.cobean.backend.roasters.domain.Roasters;

import java.util.List;

public interface RoastersRepository {

    void save(Roasters roasters);

    void addBean(Long id, Bean bean);

    void removeBean(Long id, Bean bean);

    Roasters findById(Long id);

    List<Roasters> findAllRoasters();

    void deleteRoasters(Long id);


}

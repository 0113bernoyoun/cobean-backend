package com.cobean.backend.roasters.service;

import com.cobean.backend.bean.domain.Bean;
import com.cobean.backend.bean.model.BeanDTO;
import com.cobean.backend.roasters.model.RoastersDTO;

import java.util.List;

public interface RoastersService {

    void save(RoastersDTO roastersDTO);

    void addBean(Long roastersId, BeanDTO beanDTO);

    void removeBean(Long roastersId, BeanDTO beanDTO);

    RoastersDTO findById(Long id);

    List<RoastersDTO> findAllRoasters();

    void deleteRoasters(Long id);
}

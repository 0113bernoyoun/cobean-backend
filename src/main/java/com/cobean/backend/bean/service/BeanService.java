package com.cobean.backend.bean.service;

import com.cobean.backend.bean.model.BeanDTO;

import java.util.List;

public interface BeanService {

    void save(BeanDTO beanDTO);

    void saveAll(List<BeanDTO> beanDTOList);

    BeanDTO findBean(Long id);

    List<BeanDTO> findBeans(List<Long> idList);

}

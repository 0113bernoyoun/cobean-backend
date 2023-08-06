package com.cobean.backend.bean.repository;

import com.cobean.backend.bean.domain.Bean;

import java.util.List;

public interface BeanRepository {

    void save(Bean bean);

    void saveAll(List<Bean> beanList);

    Bean findBean(Long id);

    List<Bean> findBeans(List<Long> idList);

    void addCupnote(String cupnote);

    void deleteCupnote(String cupnote);

    void updateAllCupnote(String cupnote);

    List<Bean> getAllBeans();
}

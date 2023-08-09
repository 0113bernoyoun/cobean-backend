package com.cobean.backend.bean.service;

import com.cobean.backend.bean.model.BeanDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BeanServiceImpl implements BeanService{
    @Override
    public void save(BeanDTO beanDTO) {

    }

    @Override
    public void saveAll(List<BeanDTO> beanDTOList) {

    }

    @Override
    public BeanDTO findBean(Long id) {
        return null;
    }

    @Override
    public List<BeanDTO> findBeans(List<Long> idList) {
        return null;
    }
}

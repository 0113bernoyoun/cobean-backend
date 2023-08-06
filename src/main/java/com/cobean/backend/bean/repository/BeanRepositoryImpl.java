package com.cobean.backend.bean.repository;

import com.cobean.backend.bean.domain.Bean;
import com.cobean.backend.common.exception.CustomException;
import com.cobean.backend.common.exception.ExceptionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BeanRepositoryImpl implements BeanRepository {

    private final BeanJpaRepository beanJpaRepository;


    @Override
    @Transactional
    public void save(Bean bean) {
        beanJpaRepository.save(bean);
    }

    @Override
    @Transactional
    public void saveAll(List<Bean> beanList) {
        beanJpaRepository.saveAll(beanList);
    }

    @Override
    public Bean findBean(Long id) {
        return beanJpaRepository.findById(id).orElseThrow(() -> new CustomException(ExceptionType.BEAN_NOT_FOUND));
    }

    @Override
    public List<Bean> findBeans(List<Long> idList) {
        List<Bean> resultList = beanJpaRepository.findAllById(idList);
        if(resultList.isEmpty()){
            throw new CustomException(ExceptionType.BEAN_NOT_FOUND);
        }

        return resultList;
    }

    @Override
    public void addCupnote(String cupnote) {

    }

    @Override
    public void deleteCupnote(String cupnote) {

    }

    @Override
    public void updateAllCupnote(String cupnote) {

    }

    @Override
    public List<Bean> getAllBeans() {
        List<Bean> resultList = beanJpaRepository.findAll();
        if(resultList.isEmpty()){
            throw new CustomException(ExceptionType.BEAN_NOT_FOUND);
        }

        return resultList;
    }
}

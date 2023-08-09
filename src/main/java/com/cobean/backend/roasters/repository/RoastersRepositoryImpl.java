package com.cobean.backend.roasters.repository;

import com.cobean.backend.bean.domain.Bean;
import com.cobean.backend.common.exception.CustomException;
import com.cobean.backend.common.exception.ExceptionType;
import com.cobean.backend.roasters.domain.Roasters;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class RoastersRepositoryImpl implements RoastersRepository {

    private final RoastersJpaRepository roastersJpaRepository;

    @Override
    public void save(Roasters roasters) {
        roastersJpaRepository.save(roasters);
    }

    @Override
    public void addBean(Long id, Bean bean) {
        Roasters roasters = findById(id);
        roasters.addBean(bean);
    }

    @Override
    public void removeBean(Long id, Bean bean) {
        Roasters roasters = findById(id);
        roasters.removeBean(bean);
    }

    @Override
    public Roasters findById(Long id) {
        return roastersJpaRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> {
            log.error(id + "를 가진 roasters가 존재하지 않습니다.");
            return new CustomException(ExceptionType.ROASTERS_NOT_FOUND);
        });
    }

    @Override
    public List<Roasters> findAllRoasters() {
        return roastersJpaRepository.findAllByIsDeletedFalse();
    }

    @Override
    public void deleteRoasters(Long id) {
        Roasters roasters = findById(id);
        roasters.deleteRoasters();
    }

}

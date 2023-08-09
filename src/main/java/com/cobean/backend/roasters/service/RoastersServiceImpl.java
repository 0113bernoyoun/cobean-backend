package com.cobean.backend.roasters.service;

import com.cobean.backend.bean.domain.Bean;
import com.cobean.backend.bean.model.BeanDTO;
import com.cobean.backend.bean.model.mapper.BeanDtoMapper;
import com.cobean.backend.roasters.domain.Roasters;
import com.cobean.backend.roasters.model.RoastersDTO;
import com.cobean.backend.roasters.model.mapper.RoastersModelMapper;
import com.cobean.backend.roasters.repository.RoastersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class RoastersServiceImpl implements RoastersService{

    private final RoastersRepository roastersRepository;

    @Override
    public void save(RoastersDTO roastersDTO) {
        roastersRepository.save(new Roasters(roastersDTO.name()));
    }

    @Override
    public void addBean(Long roastersId, BeanDTO beanDTO) {

    }

    @Override
    public void removeBean(Long roastersId, BeanDTO beanDTO) {

    }

    @Override
    public RoastersDTO findById(Long id) {
        return RoastersModelMapper.INSTANCE.roastersToDto(roastersRepository.findById(id));
    }

    @Override
    public List<RoastersDTO> findAllRoasters() {
        return roastersRepository.findAllRoasters().stream().map(r -> RoastersModelMapper.INSTANCE.roastersToDto(r)).collect(Collectors.toList());
    }

    @Override
    public void deleteRoasters(Long id) {

    }
}

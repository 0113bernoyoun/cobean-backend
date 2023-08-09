package com.cobean.backend.roasters.repository;

import com.cobean.backend.bean.domain.Bean;
import com.cobean.backend.bean.fixture.BeanFixtures;
import com.cobean.backend.bean.repository.BeanRepository;
import com.cobean.backend.roasters.domain.Roasters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Roasters 레포지토리 테스트")
@SpringBootTest
class RoastersRepositoryTest {

    @Autowired
    private RoastersRepository roastersRepository;

    @Autowired
    private BeanRepository beanRepository;
    
    
    @Test
    public void 로스터스_저장_테스트() throws Exception{
        // given
        String roastersName = "테스트 로스터스";
        // when
        roastersRepository.save(new Roasters(roastersName));
        Roasters roasters = roastersRepository.findById(1L);
        // then
        assertEquals(roasters.getId(), 1);
    }

    @Test
    @Transactional
    public void 로스터스_원두_추가_테스트() throws Exception{
        // given
        String roastersName = "테스트 로스터스";
        roastersRepository.save(new Roasters(roastersName));
        Roasters roasters = roastersRepository.findById(1L);
        // when
        BeanFixtures.createBean("테스트_원두", roasters);
        // then
        assertEquals(roasters.getBeanList().size(), 1);
    }

    @Test
    @Transactional
    public void 로스터스_원두_제거_테스트() throws Exception{
        // given
        String roastersName = "테스트 로스터스";
        roastersRepository.save(new Roasters(roastersName));
        Roasters roasters = roastersRepository.findById(1L);
        Bean bean = BeanFixtures.createBean("테스트_원두", roasters);
        beanRepository.save(bean);
        Bean findBean = beanRepository.findBean(1L);

        // when
        roastersRepository.removeBean(roasters.getId(), findBean);
        // then
        assertEquals(roasters.getBeanList().size(), 0);
    }

    @Test
    @Transactional
    public void 로스터스_삭제_테스트() throws Exception{
        // given
        String roastersName = "테스트 로스터스";
        roastersRepository.save(new Roasters(roastersName));
        Roasters roasters = roastersRepository.findById(1L);
        Bean bean = BeanFixtures.createBean("테스트_원두", roasters);
        beanRepository.save(bean);
        // when
        roastersRepository.deleteRoasters(roasters.getId());
        // then
        assertEquals(roastersRepository.findAllRoasters().size(), 0);

    }

}
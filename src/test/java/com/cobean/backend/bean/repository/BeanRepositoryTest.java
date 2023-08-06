package com.cobean.backend.bean.repository;

import com.cobean.backend.bean.domain.Bean;
import com.cobean.backend.bean.fixture.BeanFixtures;
import com.cobean.backend.roasters.domain.Roasters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@DisplayName("Bean 레포지토리 테스트")
@SpringBootTest
class BeanRepositoryTest {

    @Autowired
    private BeanRepository beanRepository;

    private Bean bean1 = BeanFixtures.createBean();
    private Bean bean2 = BeanFixtures.createBean("테스트원두", new Roasters("아이딜"));
    private List<Bean> beanList = BeanFixtures.createBeanList();

    @Test
    public void 단건_저장_테스트() throws Exception{
        // when
        beanRepository.save(bean1);
        Bean findBean = beanRepository.findBean(bean1.getId());
        // then
        Assertions.assertEquals(bean1.getName(), findBean.getName());
    }

    @Test
    public void 복수_저장_테스트() throws Exception{
        // when
        beanRepository.saveAll(beanList);
        List<Long> beanIdList = beanList.stream().map(b -> b.getId()).collect(Collectors.toList());
        List<Bean> beans = beanRepository.findBeans(beanIdList);
        boolean isMatch = beans.stream().map(Bean::getId).allMatch(beanIdList::contains);
        Assertions.assertEquals(true, isMatch);
    }

    @Test
    @Transactional
    public void 로스터스_조회_테스트() throws Exception{
        // when
        beanRepository.save(bean2);
        Bean bean = beanRepository.findBean(bean2.getId());
        // then
        Assertions.assertNotNull(bean.getRoasters().getName());
        Assertions.assertEquals(bean.getRoasters().getName(), bean2.getRoasters().getName());
    }

    @Test
    public void 컵노트_추가_테스트() throws Exception{
        // given

        // when

        // then

    }

}
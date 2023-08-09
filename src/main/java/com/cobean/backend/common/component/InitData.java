package com.cobean.backend.common.component;

import com.cobean.backend.bean.domain.Bean;
import com.cobean.backend.bean.repository.BeanRepository;
import com.cobean.backend.roasters.domain.Roasters;
import com.cobean.backend.roasters.repository.RoastersRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class InitData {

    private final RoastersRepository roastersRepository;
    private final BeanRepository beanRepository;

    @PostConstruct
    public void initData(){
        String roastersName1 = "1번가 로스터스";
        String roastersName2 = "시골 로스터스";
        String roastersName3 = "도시 로스터스";
        roastersRepository.save(new Roasters(roastersName1));
        roastersRepository.save(new Roasters(roastersName2));
        roastersRepository.save(new Roasters(roastersName3));
        Roasters roasters1 = roastersRepository.findById(1L);
        Roasters roasters2 = roastersRepository.findById(2L);
        Roasters roasters3 = roastersRepository.findById(3L);

        createBean("대충 만든 원두", roasters1);
        createBean("잘 만든 원두", roasters2);
        createBean("세상 누구보다 맛있는 원두", roasters3);


        System.out.println(roasters1.getBeanList());
    }



    @Transactional
    public void createBean(String name, Roasters roasters){
        beanRepository.save(new Bean(name, 200, 14500L, roasters, "#호두#라즈베리", "아무튼 존맛탱입니다.", "aws.amuURL.link"));
    }
}

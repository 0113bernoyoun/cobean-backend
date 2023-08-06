package com.cobean.backend.bean.fixture;

import com.cobean.backend.bean.domain.Bean;
import com.cobean.backend.roasters.domain.Roasters;

import java.util.ArrayList;
import java.util.List;

public class BeanFixtures {

    public static Bean createBean(String name, Roasters roasters) {
        return new Bean(name, 200, 14500L, roasters, "#호두#라즈베리", "아무튼 존맛탱입니다.", "aws.amuURL.link");
    }

    public static Bean createBean(){
        return new Bean("기본이름", 200, 14500L, new Roasters("그 로스터스"), "#호두#라즈베리", "아무튼 존맛탱입니다.", "aws.amuURL.link");
    }

    public static List<Bean> createBeanList(){
        List<Bean> beanList = new ArrayList<>();
        beanList.add(createBean());
        beanList.add(createBean("전쟁결코전쟁", new Roasters("한국어딘가")));
        beanList.add(createBean("원두이름", new Roasters("그 원두")));

        return beanList;
    }
}

package com.cobean.backend.bean.domain;

import com.cobean.backend.roasters.domain.Roasters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Bean 엔티티 테스트")
class BeanEntityTest {


    @Test
    public void 커피_엔티티_생성_테스트() throws Exception {
        //given
        String name = "케냐&에티오피아";
        Roasters roasters = new Roasters("테스트_로스터스");
        java.lang.Long price = 40000L;
        String cupnoteList = "호두";
        // when
        Bean bean = new Bean(name, 200, price, roasters, cupnoteList, "", "");
        // then
        Assertions.assertNotNull(bean);

        bean.addCupnote("라즈베리");
        System.out.println(bean.getCupnoteList());
    }

}
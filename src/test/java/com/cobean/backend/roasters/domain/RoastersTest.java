package com.cobean.backend.roasters.domain;

import com.cobean.backend.bean.domain.Bean;
import com.cobean.backend.bean.fixture.BeanFixtures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Roasters 엔티티 테스트")
class RoastersTest {

    private Bean bean1 = BeanFixtures.createBean("테스트원두", new Roasters("아무 로스터스"));

    @Test
    public void 로스터스_엔티티_생성_테스트() throws Exception{
        // given
        String roastersName = "대충 로스터스";
        // when
        Roasters roasters = new Roasters(roastersName);
        // then
        Assertions.assertNotNull(roasters);
    }

    @Test
    public void 로스터스_원두_추가_테스트() throws Exception{
        // when
        Roasters roasters = new Roasters("대충 그 로스터스");
        new Bean("테스트원두",100, 14000L, roasters, "#호두#베리", "제곧내", "aws.image.url");
        // then
        assertNotEquals(0, roasters.getBeanList().size());
        assertEquals(1, roasters.getBeanList().size());
    }

}
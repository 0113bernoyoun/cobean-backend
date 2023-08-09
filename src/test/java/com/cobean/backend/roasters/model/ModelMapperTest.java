package com.cobean.backend.roasters.model;

import com.cobean.backend.roasters.domain.Roasters;
import com.cobean.backend.roasters.model.mapper.RoastersModelMapper;
import com.cobean.backend.roasters.repository.RoastersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@DisplayName("Roasters와 RoastersDTO과 modelMapper로 상호 전환되는지 확인한다.")
@SpringBootTest
public class ModelMapperTest {

    @Autowired
    RoastersRepository roastersRepository;


    @Test
    @Transactional
    public void 엔티티_DTO_변환_테스트() throws Exception{
        // given
        String roastersName = "테스트_로스터스";
        roastersRepository.save(new Roasters(roastersName));
        Roasters roasters = roastersRepository.findById(1L);
        // when
        RoastersDTO roastersDTO = RoastersModelMapper.INSTANCE.roastersToDto(roasters);
        // then
        Assertions.assertNotNull(roastersDTO.id());
        Assertions.assertEquals(roastersDTO.id(), roasters.getId());
    }
}

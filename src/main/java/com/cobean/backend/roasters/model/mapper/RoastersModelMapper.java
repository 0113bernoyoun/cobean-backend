package com.cobean.backend.roasters.model.mapper;

import com.cobean.backend.roasters.domain.Roasters;
import com.cobean.backend.roasters.model.RoastersDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoastersModelMapper {

    RoastersModelMapper INSTANCE = Mappers.getMapper(RoastersModelMapper.class);

    RoastersDTO roastersToDto(Roasters roasters);
}

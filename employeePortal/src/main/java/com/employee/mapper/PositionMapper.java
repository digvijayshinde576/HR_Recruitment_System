package com.employee.mapper;

import com.employee.dto.PositionRequestDto;
import com.employee.dto.PositionResponseDto;
import com.employee.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PositionMapper {


    Position requestToEntity(PositionRequestDto dto);

    PositionResponseDto entityToResponse(Position save);
}

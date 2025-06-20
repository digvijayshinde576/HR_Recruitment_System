package com.employee.mapper;

import com.employee.dto.CandidateRequestDto;
import com.employee.dto.CandidateResponseDto;
import com.employee.entity.Candidate;
import com.employee.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CandidateMapper {

    CandidateResponseDto entityToResponse(Candidate save);

    @Mapping(source = "positionIds", target = "positions")
    Candidate requestToEntity(CandidateRequestDto dto);

    default List<Position> mapPositionIdsToPositions(List<Long> ids) {
        if (ids == null) return null;
        return ids.stream().map(id -> Position.builder().id(id).build()).toList();
    }
}



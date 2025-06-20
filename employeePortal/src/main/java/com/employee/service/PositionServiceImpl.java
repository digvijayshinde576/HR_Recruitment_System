package com.employee.service;

import com.employee.dto.PositionProjection;
import com.employee.dto.PositionRequestDto;
import com.employee.dto.PositionResponseDto;
import com.employee.entity.Position;
import com.employee.mapper.PositionMapper;
import com.employee.repository.CandidateRepository;
import com.employee.repository.PositionRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.employee.util.UpdateUtil.getJsonNode;
import static com.employee.util.UpdateUtil.readValue;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    private final CandidateRepository candidateRepository;
    private final PositionMapper positionMapper;

    @Override
    public PositionResponseDto create(PositionRequestDto dto) {
        return positionMapper.entityToResponse(positionRepository.save(positionMapper.requestToEntity(dto)));
    }

    @Override
    public Page<PositionProjection> getAll(Pageable pageable) {
        return positionRepository.findAllProjectedBy(pageable);
    }

    @Override
    public PositionResponseDto getById(Long id) {
        Position position = positionRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Position not found with ID: " + id));
        return positionMapper.entityToResponse(position);
    }

    public PositionResponseDto update(Long id, String updatedDto) {
        Position fieldsToUpdate = Optional.ofNullable(readValue(updatedDto, Position.class)).orElseThrow(() -> new RuntimeException("Invalid Position request payload"));
        Position existing = positionRepository.findById(id).orElseThrow(() -> new RuntimeException("Position not found with ID: " + id));
        JsonNode jsonNode = getJsonNode(updatedDto);
        if (jsonNode.has("positionName")) {
            int length = fieldsToUpdate.getPositionName().length();
            if (!(length >= 2 && length <= 100)) {
                throw new RuntimeException("Title must be between 2 and 100 characters");
            }
            existing.setPositionName(fieldsToUpdate.getPositionName());
        }
        return positionMapper.entityToResponse(positionRepository.save(existing));
    }

//    @Override
//    public void delete(Long id) {
//        Position position = positionRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Position not found with ID: " + id));
//        positionRepository.delete(position);
//    }
}

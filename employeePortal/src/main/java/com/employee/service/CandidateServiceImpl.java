package com.employee.service;

import com.employee.dto.CandidateProjection;
import com.employee.dto.CandidateRequestDto;
import com.employee.dto.CandidateResponseDto;
import com.employee.entity.Candidate;
import com.employee.entity.Position;
import com.employee.mapper.CandidateMapper;
import com.employee.repository.CandidateRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import static com.employee.util.UpdateUtil.getJsonNode;
import static com.employee.util.UpdateUtil.readValue;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final CandidateMapper candidateMapper;


    public CandidateResponseDto create(CandidateRequestDto dto) {
        return candidateMapper.entityToResponse(candidateRepository.save(candidateMapper.requestToEntity(dto)));
    }

    @Override
    public Page<CandidateProjection> getAll(Pageable pageable) {
//        return candidateRepository.findAll().stream()
//                .map(candidateMapper::entityToResponse)
//                .collect(Collectors.toList());

        return candidateRepository.findAllProjectedBy(pageable);
    }

    @Override
    public CandidateResponseDto getById(Long id) {
        return candidateMapper.entityToResponse(candidateRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Candidate not found with ID: " + id)));
    }

    @Override
    public CandidateResponseDto update(Long id, String updatedDto)  {
        CandidateRequestDto fieldsToUpdate = Optional.ofNullable(readValue(updatedDto, CandidateRequestDto.class)).orElseThrow(() -> new RuntimeException("Invalid Candidate payload"));
        Candidate existing = candidateRepository.findById(id).orElseThrow(() -> new RuntimeException("Candidate not found with ID: " + id));
        JsonNode jsonNode = getJsonNode(updatedDto);
        if (jsonNode.has("name")) {
            String fullName = fieldsToUpdate.getName();
            if (fullName == null || fullName.length() < 2 || fullName.length() > 100) {
                throw new RuntimeException("Full name must be between 2 and 100 characters");
            }
            existing.setName(fullName);
        }
        if (jsonNode.has("email")) {
            String email = fieldsToUpdate.getEmail();
            if (email == null || email.length() < 5 || email.length() > 50 || !email.contains("@")) {
                throw new RuntimeException("Invalid email format");
            }
            existing.setEmail(email);
        }
        if (jsonNode.has("dob")) {
            LocalDate dob = fieldsToUpdate.getDob();
            if (dob == null) {
                throw new RuntimeException("Date of birth must be a past date and cannot be null");
            }
            existing.setDob(dob);
        }
        if (jsonNode.has("positionIds")) {
            List<Long> positionIds = fieldsToUpdate.getPositionIds();
            if (positionIds != null && !positionIds.isEmpty()) {
                List<Position> positions = new ArrayList<>(positionIds.stream().map(idVal -> Position.builder().id(idVal).build()).toList());
                existing.setPositions(positions);
            } else {
                existing.setPositions(null);
            }
        }
        return candidateMapper.entityToResponse(candidateRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Candidate not found with ID: " + id));
        candidate.getPositions().clear();
        candidateRepository.delete(candidate);
    }
}


//public CandidateResponseDto create(CandidateRequestDto dto) {
//    //        Candidate candidate = candidateMapper.candidateRequestDtoToCandidateEntity(dto);
//    //        List<Position> pid = new ArrayList<>();
//    //        for (Long positionIds : dto.getPositionIds() ) {
//    //            Position position = positionRepository.findById(positionIds)
//    //                    .orElseThrow(() -> new ResourceNotFoundException(""));
//    //            pid.add(position);//        }
//    //        candidate.setPositions(pid);
//    //        return candidateMapper.candidateEntityToCandidateResponseDto(candidateRepository.save(candidateMapper.candidateRequestDtoToCandidateEntity(dto)));
//    //        return candidateMapper.candidateEntityToCandidateResponseDto(candidateRepository.save(candidate));    }
//}

package com.employee.controller;

import com.employee.dto.CandidateProjection;
import com.employee.dto.CandidateRequestDto;
import com.employee.dto.CandidateResponseDto;
import com.employee.dto.RestApiResponse;
import com.employee.service.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping
    public ResponseEntity<RestApiResponse<CandidateResponseDto>> create(@Valid @RequestBody CandidateRequestDto dto) {
        CandidateResponseDto created = candidateService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(RestApiResponse.<CandidateResponseDto>builder().message("Candidate Created Successfully...").data(created).timestamp(new Date()).build());
    }

    @GetMapping
    public ResponseEntity<RestApiResponse<Page<CandidateProjection>>> getAll(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<CandidateProjection> candidates = candidateService.getAll(pageable);
        return ResponseEntity.ok(RestApiResponse.<Page<CandidateProjection>>builder().message("All Candidates Fetched Successfully...").data(candidates).timestamp(new Date()).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestApiResponse<Optional<CandidateResponseDto>>> getById(@PathVariable Long id) {
        Optional<CandidateResponseDto> candidate = Optional.ofNullable(candidateService.getById(id));
        return ResponseEntity.ok(RestApiResponse.<Optional<CandidateResponseDto>>builder().message("Candidate Fetched Successfully...").data(candidate).timestamp(new Date()).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestApiResponse<CandidateResponseDto>> update(@PathVariable Long id, @RequestBody String candidateJson) {
        CandidateResponseDto updated = candidateService.update(id, candidateJson);
        return ResponseEntity.ok(RestApiResponse.<CandidateResponseDto>builder().message("Candidate Updated Successfully...").data(updated).timestamp(new Date()).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestApiResponse<Object>> delete(@PathVariable Long id) {
        candidateService.delete(id);
        return ResponseEntity.ok(RestApiResponse.builder().message("Candidate Deleted Successfully...").timestamp(new Date()).build());
    }
}

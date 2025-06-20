package com.employee.controller;

import com.employee.dto.PositionProjection;
import com.employee.dto.PositionRequestDto;
import com.employee.dto.PositionResponseDto;
import com.employee.dto.RestApiResponse;
import com.employee.service.PositionService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
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
@RequestMapping("/api/positions")
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @PostMapping
    public ResponseEntity<RestApiResponse<PositionResponseDto>> create(@Valid @RequestBody PositionRequestDto dto) {
        PositionResponseDto created = positionService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(RestApiResponse.<PositionResponseDto>builder().message("Position Created Successfully...").data(created).timestamp(new Date()).build());
    }

    @GetMapping
    public ResponseEntity<RestApiResponse<Page<PositionProjection>>> getAll(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<PositionProjection> positions = positionService.getAll(pageable);
        return ResponseEntity.ok(RestApiResponse.<Page<PositionProjection>>builder().message("All Positions Fetched Successfully...").data(positions).timestamp(new Date()).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestApiResponse<Optional<PositionResponseDto>>> getById(@PathVariable Long id) {
        Optional<PositionResponseDto> position = Optional.ofNullable(positionService.getById(id));
        return ResponseEntity.ok(RestApiResponse.<Optional<PositionResponseDto>>builder().message("Position Fetched Successfully...").data(position).timestamp(new Date()).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestApiResponse<PositionResponseDto>> updatePosition(@PathVariable(name = "id") Long id, @Parameter(required = false, schema = @Schema(implementation = PositionRequestDto.class)) @RequestBody String positionDto) throws RuntimeException {
        PositionResponseDto updated = positionService.update(id, positionDto);
        return ResponseEntity.ok(RestApiResponse.<PositionResponseDto>builder().message("Position Updated Successfully...").data(updated).timestamp(new Date()).build());
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<RestApiResponse<Object>> delete(@PathVariable Long id) {
//        positionService.delete(id);
//        return ResponseEntity.ok(RestApiResponse.builder().message("Position Deleted Successfully...").timestamp(new Date()).build());
//    }
}
//@PageableDefault(size = 1, sort = "id", direction = Sort.Direction.ASC)
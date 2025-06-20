package com.employee.controller;

import com.employee.dto.RestApiResponse;
import com.employee.dto.SubCategoryDto;
import com.employee.dto.SubCategoryResponseDto;
import com.employee.service.SubCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subcategories")
@RequiredArgsConstructor
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @PostMapping
    public ResponseEntity<RestApiResponse<SubCategoryResponseDto>> create(@Valid @RequestBody SubCategoryDto dto) {
        SubCategoryResponseDto created = subCategoryService.create(dto);
        RestApiResponse<SubCategoryResponseDto> response = RestApiResponse.<SubCategoryResponseDto>builder()
                .message("SubCategory Created Successfully...")
                .data(created)
                .timestamp(new Date())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<RestApiResponse<List<SubCategoryResponseDto>>> getAll() {
        List<SubCategoryResponseDto> subCategories = subCategoryService.getAll();
        return ResponseEntity.ok(RestApiResponse.<List<SubCategoryResponseDto>>builder()
                .message("All SubCategories Fetched Successfully...")
                .data(subCategories)
                .timestamp(new Date())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestApiResponse<Optional<SubCategoryResponseDto>>> getById(@PathVariable Long id) {
        Optional<SubCategoryResponseDto> subCategory = Optional.ofNullable(subCategoryService.getById(id));
        return ResponseEntity.ok(RestApiResponse.<Optional<SubCategoryResponseDto>>builder()
                .message("SubCategory Fetched Successfully...")
                .data(subCategory)
                .timestamp(new Date())
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestApiResponse<SubCategoryResponseDto>> update(@PathVariable Long id, @RequestBody String subCategoryDtoJson) {
        SubCategoryResponseDto updated = subCategoryService.update(id, subCategoryDtoJson);
        RestApiResponse<SubCategoryResponseDto> response = RestApiResponse.<SubCategoryResponseDto>builder()
                .message("SubCategory Updated Successfully...")
                .data(updated)
                .timestamp(new Date())
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestApiResponse<Object>> delete(@PathVariable Long id) {
        subCategoryService.delete(id);
        return ResponseEntity.ok(RestApiResponse.builder()
                .message("SubCategory Deleted Successfully...")
                .timestamp(new Date())
                .build());
    }
}

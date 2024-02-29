package com.codejava.course.model.dto;

import com.codejava.course.model.entity.Category;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class CategoryDto {
    private Long id;
    private String name;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public static CategoryDto from(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .createdAt(category.getCreatedAt())
                .updatedAt(category.getUpdatedAt())
                .build();
    }
}

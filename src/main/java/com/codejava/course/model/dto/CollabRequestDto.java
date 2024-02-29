package com.codejava.course.model.dto;

import com.codejava.course.model.entity.CollabRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CollabRequestDto {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String description;
    private String photographicEvidenceUrl; //ảnh minh chứng
    private String status;
    private CollabDto collabDto;
    private UserDto userDto;
    private String title;
    private String tag;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;


    public static CollabRequestDto from(CollabRequest collabRequest) {
        return CollabRequestDto.builder()
                .id(collabRequest.getId())
                .fullName(collabRequest.getFullName())
                .email(collabRequest.getEmail())
                .phone(collabRequest.getPhone())
                .address(collabRequest.getAddress())
                .description(collabRequest.getDescription())
                .photographicEvidenceUrl(collabRequest.getPhotographicEvidenceUrl())
                .status(collabRequest.getStatus())
                .collabDto(CollabDto.from(collabRequest.getCollab()))
                .userDto(UserDto.from(collabRequest.getUser()))
                .title(collabRequest.getTitle())
                .tag(collabRequest.getTag())
                .createdAt(collabRequest.getCreatedAt())
                .updatedAt(collabRequest.getUpdatedAt())
                .build();
    }
}

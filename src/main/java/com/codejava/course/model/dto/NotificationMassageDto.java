package com.codejava.course.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class NotificationMassageDto {
    private String title;
    private String message;
    private String imageUrl;
    private String username;
}

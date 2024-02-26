package com.codejava.course.model.dto;

import com.codejava.course.model.entity.Notification;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class NotificationDto {
    private Long id;
    private String title;
    private String content;
    private String imageUrl;
    @JsonFormat(pattern = "HH:mm dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    protected LocalDateTime createdAt;

    public static NotificationDto from(Notification notification) {
        return NotificationDto.builder()
                .id(notification.getId())
                .title(notification.getTitle())
                .content(notification.getContent())
                .imageUrl(notification.getImageUrl())
                .createdAt(notification.getCreatedAt())
                .build();
    }
}

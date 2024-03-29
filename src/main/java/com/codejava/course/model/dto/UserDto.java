package com.codejava.course.model.dto;

import com.codejava.course.model.entity.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserDto {
    private String username;
    private String name;
    private String avatarUrl;
    private String role;
    private String categoryAccount;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public static UserDto from(User user) {
        String categoryAccount = "Farmer";
        if(user.getRole().getName().equals("ROLE_ENTERPRISE")) {
            categoryAccount = "Enterprise";
        } else if (user.getRole().getName().equals("ROLE_VOLUNTEER")) {
            categoryAccount = "Volunteer";
        } else if (user.getRole().getName().equals("ROLE_ADMIN")) {
            categoryAccount = "Admin";
        }

        return UserDto.builder()
                .username(user.getUsername())
                .name(user.getName())
                .avatarUrl(user.getAvatarUrl())
                .role(user.getRole().getName())
                .categoryAccount(categoryAccount)
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}

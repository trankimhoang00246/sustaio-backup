package com.codejava.course.service.impl;

import com.codejava.course.model.dto.NotificationMassageDto;
import com.codejava.course.repository.NotificationRepository;
import com.codejava.course.repository.UserRepository;
import com.codejava.course.service.NotificationMessagingService;
import com.codejava.course.utils.SecurityUtils;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class NotificationMessagingServiceImpl implements NotificationMessagingService {
    private final FirebaseMessaging firebaseMessaging;
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public String sendNotification(NotificationMassageDto notificationMassageDto) {
        Notification notification = Notification.builder()
                .setTitle(notificationMassageDto.getTitle())
                .setBody(notificationMassageDto.getMessage())
                .setImage(notificationMassageDto.getImageUrl())
                .build();

        Message msg = Message.builder()
                .setToken("dU6yivTrSwuAsMjpRdaeSH:APA91bGolQjBMIe6YkR4qt7TthrfvLj0rdXl_NGZBokWbNcWBUPq9XSEZmlUde9nH-B25TlnedxJB5kgdwLcvp8L8TIO8LuhE1SNQjA1dtJ7IUEG2Ssa4ISx09zd7p1u9eFegFecsv25")
                .setNotification(notification)
                .build();

        try {
            String id = firebaseMessaging.send(msg);

            notificationRepository.save(
                    com.codejava.course.model.entity.Notification.builder()
                            .title(notificationMassageDto.getTitle())
                            .content(notificationMassageDto.getMessage())
                            .imageUrl(notificationMassageDto.getImageUrl())
                            .user(userRepository.findByUsername(notificationMassageDto.getUsername())
                                    .orElseThrow(() -> new IllegalArgumentException("User not found with username: " + notificationMassageDto.getUsername())))
                            .build()
            );
            log.info("Successfully sent message: " + id);
            return id;
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
            return "Error sending message: " + e.getMessage();
        }
    }
}

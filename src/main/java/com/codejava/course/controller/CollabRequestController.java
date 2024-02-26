package com.codejava.course.controller;

import com.codejava.course.model.dto.CollabRequestDto;
import com.codejava.course.model.dto.NotificationMassageDto;
import com.codejava.course.model.form.CollabRequestForm;
import com.codejava.course.service.CollabRequestService;
import com.codejava.course.service.NotificationMessagingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/collab-requests")
public class CollabRequestController {
    private final CollabRequestService collabRequestService;
    private final NotificationMessagingService notificationMessagingService;

    @GetMapping
    public ResponseEntity getMyCollabRequests() {
        return ResponseEntity.ok(collabRequestService.getMyCollabRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity getCollabRequestById(@PathVariable("id") long id) {
        return ResponseEntity.ok(collabRequestService.getCollabRequestById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCollabRequest(@PathVariable("id") long id) {
        return ResponseEntity.ok(collabRequestService.deleteCollabRequest(id));
    }

    @PostMapping
    public ResponseEntity createCollabRequest(@Valid @RequestBody  CollabRequestForm collabRequestForm) {
        return ResponseEntity.ok(collabRequestService.createCollabRequest(collabRequestForm));
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateStatusCollabRequest(@PathVariable("id") long id, @RequestParam("status") String status) {
        CollabRequestDto collabRequestDto = collabRequestService.updateStatusCollabRequest(status, id);

        if(collabRequestDto == null) {
            return ResponseEntity.badRequest().build();
        }
        notificationMessagingService.sendNotification(
                NotificationMassageDto.builder()
                        .title("Collab Request Updated")
                        .message("Request with id " + id + " has been " + status.toLowerCase())
                        .imageUrl("https://picsum.photos/500/500")
                        .username(collabRequestDto.getUserDto().getUsername())
                        .build()
        );
        return ResponseEntity.ok(collabRequestDto);
    }
}

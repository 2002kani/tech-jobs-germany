package com.studitech.notificationservice.service;

import com.studitech.notificationservice.entity.Notification;
import com.studitech.notificationservice.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmailService implements IEmailService {

    private final NotificationRepository notificationRepository;

    @Override
    public void sendNewJobsEmail() {
        List<Notification> notifications = notificationRepository.findByEmailSent(false);


    }
}

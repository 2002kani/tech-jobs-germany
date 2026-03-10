package com.studitech.notificationservice.repository;

import com.studitech.notificationservice.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByEmailSent(boolean b);
}

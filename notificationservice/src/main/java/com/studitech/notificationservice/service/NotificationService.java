package com.studitech.notificationservice.service;

import com.studitech.notificationservice.dto.JobArea;
import com.studitech.notificationservice.dto.JobDto;
import com.studitech.notificationservice.entity.EmbeddedArea;
import com.studitech.notificationservice.entity.Notification;
import com.studitech.notificationservice.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class NotificationService implements INotificationService {

    private final NotificationRepository notificationRepository;
    private final EmailService emailService;

    @KafkaListener(topics = "jobs.created")
    @Override
    public void notifyJobs(JobDto job) {
        log.info("Job received: {}", job);

        Notification notification = createNotification(job);
        Notification savedNotification = notificationRepository.saveAndFlush(notification);
        log.info("Notification saved: {}", savedNotification);
    }

    // Test: @Scheduled(fixedRate = 10000)
    @Override
    public void sendEmails(){
        emailService.sendNewJobsEmail();
    }

    private Notification createNotification(JobDto job){
        EmbeddedArea area = EmbeddedArea.builder()
                .postalcode(job.getArea().getPostalcode())
                .city(job.getArea().getCity())
                .street(job.getArea().getStreet())
                .region(job.getArea().getRegion())
                .build();

        return Notification.builder()
                .profession(job.getProfession())
                .title(job.getTitle())
                .area(area)
                .company(job.getCompany())
                .publishDate(job.getPublishDate())
                .modificationDate(job.getModificationDate())
                .emailSent(false)
                .build();
    }
}

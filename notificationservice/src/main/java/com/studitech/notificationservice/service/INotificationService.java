package com.studitech.notificationservice.service;

import com.studitech.notificationservice.dto.JobDto;

public interface INotificationService {
    void notifyJobs(JobDto job);
    void sendEmails();
}

package com.fricle.joblisting.service;

import com.fricle.joblisting.events.NotificationEventPublisher;
import com.fricle.joblisting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class EventServiceImpl {

    @Autowired
    NotificationEventPublisher notificationEventPublisher;
    public void raiseEvents(Employee employee){
        CompletableFuture.runAsync(()->{
            notificationEventPublisher.publish(employee);
        });

    }
}

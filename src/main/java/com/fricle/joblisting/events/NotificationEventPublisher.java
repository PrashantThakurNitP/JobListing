package com.fricle.joblisting.events;

import com.fricle.joblisting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class NotificationEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(Employee employee){
        applicationEventPublisher.publishEvent(employee);
    }
}

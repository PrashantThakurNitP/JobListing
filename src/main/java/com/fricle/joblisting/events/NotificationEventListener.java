package com.fricle.joblisting.events;

import com.fricle.joblisting.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class NotificationEventListener {

    private Executor executor = new ThreadPoolExecutor(100,100,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(10000));

    @EventListener
    public void handleNotificationEvent(Employee employee){

        try {
            log.info("Processing customer {}",employee);
        }
        catch (Exception exception){
            log.error("Unable to process",exception);
        }
    }

}

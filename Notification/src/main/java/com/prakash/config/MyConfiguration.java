package com.prakash.config;

import com.prakash.common.subscribers.EmailNotificationSubscriber;
import com.prakash.common.subscribers.NotificationSubscriber;
import com.prakash.common.subscribers.SMSNotificationSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pkagarwa on 25/11/16.
 */
@Configuration
public class MyConfiguration {

    @Autowired
    private EmailNotificationSubscriber emailNotificationSubscriber;

    @Autowired
    private SMSNotificationSubscriber smsNotificationSubscriber;

    @Bean
    public List<NotificationSubscriber> subscribers() {
        List<NotificationSubscriber> notificationSubscribers = new ArrayList<NotificationSubscriber>();
        notificationSubscribers.add(emailNotificationSubscriber);
        notificationSubscribers.add(smsNotificationSubscriber);
        return notificationSubscribers;
    }

   /* @Bean
    public  List<NotificationDO> notices() {
        List<NotificationDO> notificationSubscribers = new ArrayList<NotificationDO>();
        notificationSubscribers.add(emailNotificationSubscriber);
        notificationSubscribers.add(smsNotificationSubscriber);
        return notificationSubscribers;
    }*/
}

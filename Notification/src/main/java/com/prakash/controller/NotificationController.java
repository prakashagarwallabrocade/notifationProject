package com.prakash.controller;

import com.prakash.domain.NotificationDO;
import com.prakash.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by pkagarwa on 24/11/16.
 */

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<NotificationDO> getAllNotifications() {
        return notificationService.getAllNotifications();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public NotificationDO getNotificationByID(@PathVariable("id") int id) {

        try {
            return notificationService.getNotificationByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void dismissNotificationByID(@PathVariable("id") int id) {

        notificationService.dismissNotificationByID(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void pushNotification(@RequestBody NotificationDO notificationDO) {

        notificationService.pushNotification(notificationDO);
    }

}

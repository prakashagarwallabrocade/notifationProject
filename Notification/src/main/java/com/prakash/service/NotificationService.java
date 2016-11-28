package com.prakash.service;

import com.prakash.common.Notifier;
import com.prakash.dao.NotificationDAO;
import com.prakash.domain.NotificationDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by pkagarwa on 24/11/16.
 */

@Service
public class NotificationService {

    @Autowired
    private Notifier notifier;

    @Autowired
    private NotificationDAO notificationDAO;


    public Collection<NotificationDO> getAllNotifications() {
        return notifier.getUpdate();
    }

    public NotificationDO getNotificationByID(int id) throws Exception {
        return notificationDAO.getNotificationByID(id);
    }


    public void dismissNotificationByID(int id) {
        notificationDAO.dismissNotificationByID(id);
    }


    public void pushNotification(NotificationDO notificationDO) {
        notifier.postNotification(notificationDO);
        // notificationDAO.pushNotification(notificationDO);
    }
}

package com.prakash.dao;

import com.prakash.domain.NotificationDO;

import java.util.List;

/**
 * Created by pkagarwa on 26/11/16.
 */
public interface NotificationDAO {
    List<NotificationDO> getAllNotification();

    NotificationDO getNotificationByID(int id) throws Exception;

    void dismissNotificationByID(int id);

    void pushNotification(NotificationDO notificationDO);

    void removeNotification(NotificationDO notification);
}

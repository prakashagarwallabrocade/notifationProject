package com.prakash.common;

import com.prakash.domain.NotificationDO;

import java.util.List;

/**
 * Created by pkagarwa on 24/11/16.
 */


public interface Notifier {

    //method to notify observers of change
    public void notifyObservers();

    //method to get updates from subject
    public List<NotificationDO> getUpdate();

    public void postNotification(NotificationDO notification);
}

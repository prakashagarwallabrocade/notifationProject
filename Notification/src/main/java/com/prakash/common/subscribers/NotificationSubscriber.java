package com.prakash.common.subscribers;

/**
 * Created by pkagarwa on 24/11/16.
 */
public interface NotificationSubscriber {

    //method to update the NotificationObserver, used by Notifier
    public void checkForNotification();

    //attach with subject to observe
    //  public void listenTo(Notifier sub);
}

package com.prakash.common;

import com.prakash.common.subscribers.NotificationSubscriber;
import com.prakash.dao.NotificationDAO;
import com.prakash.domain.NotificationDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by pkagarwa on 24/11/16.
 */

@Component
public class NotifierImpl implements Notifier {


    @Autowired
    List<NotificationSubscriber> subscribers;
    @Autowired
    private NotificationDAO notificationDAO;

    public NotifierImpl() {

    }

    @Override
    public void notifyObservers() {
        //addObservers();
        System.out.print("notificationObservers size:: " + subscribers.size());
        for (NotificationSubscriber observer : subscribers) {
            //on notification all observers  checks for updates
            observer.checkForNotification();
        }

    }

 /*   private void addObservers() {
          EmailNotificationSubscriber emailNotificationSubscriber = new EmailNotificationSubscriber();
        notificationObservers.add(emailNotificationSubscriber);
    }*/


    @Override
    public List<NotificationDO> getUpdate() {
        return notificationDAO.getAllNotification();
    }

    //method to post message to the topic
    public void postNotification(NotificationDO notice) {
        System.out.println("NotificationDO Posted >>>   " + notice);
        notificationDAO.getAllNotification().add(notice);
        //this.changed=true;
        notifyObservers();
    }

  /*  @Override
    public void removeNotification(NotificationDO notification) {
        notificationDAO.removeNotification(notification);
    }
*/

}

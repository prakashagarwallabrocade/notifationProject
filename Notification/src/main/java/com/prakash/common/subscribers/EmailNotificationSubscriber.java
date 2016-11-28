package com.prakash.common.subscribers;

import com.prakash.common.Notifier;
import com.prakash.constants.DisplayChannels;
import com.prakash.domain.NotificationDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

/**
 * Created by pkagarwa on 24/11/16.
 */

@Component
public class EmailNotificationSubscriber implements NotificationSubscriber {

/*    @Autowired
    private Notifier notifier;*/

    @Autowired
    private Notifier notifier;


    @Override
    public void checkForNotification() {
        List<NotificationDO> notices = notifier.getUpdate();
        if (notices == null || notices.size() == 0) {
            System.out.println("No new Notification....");
        } else {
            for (Iterator<NotificationDO> noticeIter = notices.iterator(); noticeIter.hasNext(); ) {
                NotificationDO notice = noticeIter.next();
                if (DisplayChannels.EMAIL.equals(notice.getDisplayChannel())) {
                    System.out.println("EmailNotificationSubscriber got notifier::" + notice);
                    sendMail(notice);
                    noticeIter.remove();
                }
            }

        }
    }

    private void sendMail(NotificationDO notificationDO) {
        System.out.println("Sending email for ::" + notificationDO.getNotificationID());
    }

  /*  private void removeNotification(NotificationDO notificationDO) {
        System.out.println("Removing  notification for ::" + notificationDO.getNotificationID());
        notifier.removeNotification(notificationDO);
    }*/

 /*   @Override
    public void listenTo(Notifier sub) {
        this.notifier =sub;

    }*/
}

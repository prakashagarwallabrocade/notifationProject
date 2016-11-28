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
public class SMSNotificationSubscriber implements NotificationSubscriber {
    @Autowired
    private Notifier notifier;

    @Override
    public void checkForNotification() {
        List<NotificationDO> notices = (List<NotificationDO>) notifier.getUpdate();
        if (notices == null || notices.size() == 0) {
            System.out.println(":: No new notifier");
        } else {
            for (Iterator<NotificationDO> noticeIter = notices.iterator(); noticeIter.hasNext(); ) {
                NotificationDO notice = noticeIter.next();
                if (DisplayChannels.SMS.equals(notice.getDisplayChannel())) {
                    System.out.println("SMSNotificationSubscriber got notifier::" + notice);
                    sendSMS(notice);
                    noticeIter.remove();
                }
            }
        }

    }

    private void sendSMS(NotificationDO notificationDO) {
        System.out.println("Sending sms for ::" + notificationDO.getNotificationID());
    }


   /* @Override
    public void listenTo(Notifier sub) {
        this.notifier =sub;

    }*/
}

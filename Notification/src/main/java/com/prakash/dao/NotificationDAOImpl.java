package com.prakash.dao;

import com.prakash.constants.DisplayChannels;
import com.prakash.constants.NotificationTypes;
import com.prakash.domain.NotificationDO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pkagarwa on 24/11/16.
 */

@Component
public class NotificationDAOImpl implements NotificationDAO {

    // private static  SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();


    private static List<NotificationDO> notificationDOs = new ArrayList<NotificationDO>();

    static {
        NotificationDO notice1 = new NotificationDO();
        notice1.setNotificationID(1);
        notice1.setDescription("Notifier 1");
        notice1.setDismissed(false);
        notice1.setDisplayChannel(DisplayChannels.EMAIL);
        notice1.setEndDate(new Date().toString());
        notice1.setPublishDate(new Date().toString());
        notice1.setNotificationType(NotificationTypes.ALERT);


        NotificationDO notice2 = new NotificationDO();
        notice2.setNotificationID(2);
        notice2.setDescription("Notifier 2");
        notice1.setDismissed(false);
        notice2.setDisplayChannel(DisplayChannels.SMS);
        notice2.setEndDate(new Date().toString());
        notice2.setPublishDate(new Date().toString());
        notice2.setNotificationType(NotificationTypes.NOTIFICATION);


        NotificationDO notice3 = new NotificationDO();
        notice3.setNotificationID(3);
        notice3.setDescription("Notifier 3");
        notice3.setDismissed(true);
        notice3.setDisplayChannel(DisplayChannels.EMAIL);
        notice3.setEndDate(new Date().toString());
        notice3.setPublishDate(new Date().toString());
        notice3.setNotificationType(NotificationTypes.APPROVAL_REQUEST);


        notificationDOs.add(notice1);
        notificationDOs.add(notice2);
        notificationDOs.add(notice3);


    }

    @Override
    public List<NotificationDO> getAllNotification() {
       /* List<NotificationDO> notificationDOs;
       // SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Query q=session.createQuery("from Notification7");
        notificationDOs = (List<NotificationDO>)q.list();
       // session.save(notification);
        //notificationDOs=(List<NotificationDO>) session.get(NotificationDO.class);
        session.getTransaction().commit();
        session.close();
        return notificationDOs;*/
        // List<NotificationDO> notificationDOs=notifier.getUpdate();
        // System.out.println("Total Notification size:: " + notificationDOs.size());
        return notificationDOs;
    }

    @Override
    public NotificationDO getNotificationByID(int id) throws Exception {

     /*   List<NotificationDO> notificationDOs;
        //SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Query q=session.createQuery("from Notification7 where notificationID="+id);
        notificationDOs = (List<NotificationDO>)q.list();
        // session.save(notification);
        //notificationDOs=(List<Notifica
        // tion>) session.get(NotificationDO.class);
        session.getTransaction().commit();
        session.close();*/
        boolean matchFound = false;
        for (NotificationDO notificationDO : notificationDOs) {
            if (notificationDO.getNotificationID() == id) {
                matchFound = true;
                return notificationDO;
            }
        }
        if (matchFound == false) {
            throw new Exception("Notification Not Found.");
        }
        return null;
    }

    @Override
    public void dismissNotificationByID(int id) {
     /*  // List<NotificationDO> notifications;
       // SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Query q=session.createQuery("update Notification7  set dismissed=1 where notificationID="+id);
       // notifications= (List<NotificationDO>)q.list();
        // session.save(notification);
        //notifications=(List<Notifica
        // tion>) session.get(NotificationDO.class);
        session.getTransaction().commit();
        session.close();*/

        for (NotificationDO notificationDO : notificationDOs) {
            if (notificationDO.getNotificationID() == id) {
                notificationDO.setDismissed(true);
            }
        }

    }

    @Override
    public void pushNotification(NotificationDO notificationDO) {
        notificationDOs.add(notificationDO);

       /*// SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(s);
        session.getTransaction().commit();
        session.close();*/
    }

    @Override
    public void removeNotification(NotificationDO notification) {
        System.out.println("Before Removing Notification size:: " + notificationDOs.size());
        notificationDOs.remove(notification);
        System.out.println("After Removing Notification size:: " + notificationDOs.size());

    }
}

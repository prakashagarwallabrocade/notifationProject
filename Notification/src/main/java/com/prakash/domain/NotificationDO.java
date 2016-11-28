package com.prakash.domain;


import com.prakash.constants.DisplayChannels;
import com.prakash.constants.NotificationTypes;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pkagarwa on 24/11/16.
 */


@Entity(name = "Notification7")
public class NotificationDO implements Serializable {

    private static final long serialVersionUID = 6409267010637836869L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int notificationID;
    private String description;
    @Enumerated(EnumType.STRING)
    private NotificationTypes notificationType; //   alerts, notifications, warnings, confirmations,  approval requests
    private String publishDate;
    private String endDate;
    @Enumerated(EnumType.STRING)
    private DisplayChannels displayChannel; // web UIs, email, company instant messenger, SMS
    private boolean dismissed;

    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NotificationTypes getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationTypes notificationType) {
        this.notificationType = notificationType;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    public DisplayChannels getDisplayChannel() {
        return displayChannel;
    }


    public void setDisplayChannel(DisplayChannels displayChannel) {
        this.displayChannel = displayChannel;
    }

    public boolean getDismissed() {
        return dismissed;
    }

    public void setDismissed(boolean dismissed) {
        this.dismissed = dismissed;
    }


    @Override
    public String toString() {
        return "NotificationDO{" +
                "notificationID=" + notificationID +
                ", description='" + description + '\'' +
                ", notificationType='" + notificationType + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", displayChannel='" + displayChannel + '\'' +
                ", dismissed=" + dismissed +
                '}';
    }
}

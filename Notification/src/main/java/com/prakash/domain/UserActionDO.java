package com.prakash.domain;


import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by pkagarwa on 24/11/16.
 */
@Entity(name = "UserAction")
public class UserActionDO implements Serializable {

    private static final long serialVersionUID = -7881843959596430875L;


    private String notificationID;
    private long userID;

}

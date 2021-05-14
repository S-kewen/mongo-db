package com.boot.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @PackageName: com.boot.mongodb.entity
 * @ClassName: User
 * @Description: This is User class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-14 17:16
 */
@Data
public class User {
    @Id
    private long id;
    private String username;
    private String password;
    private int state;
    private Date addTime;
}

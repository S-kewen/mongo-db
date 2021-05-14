package com.boot.mongodb.dao;

import com.boot.mongodb.entity.User;

import java.util.List;

/**
 * @PackageName: com.boot.mongodb.dao
 * @ClassName: UserDao
 * @Description: This is UserDao interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-14 17:16
 */

public interface UserDao {
    int insertOne(User user);
    int deleteOne(User user);
    int updateOne(User user);
    List<User> list(User user);
    User selectOne(User user);
}

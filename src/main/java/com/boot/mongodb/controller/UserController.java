package com.boot.mongodb.controller;

import com.boot.mongodb.dao.UserDao;
import com.boot.mongodb.entity.User;
import com.boot.mongodb.result.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @PackageName: com.boot.mongodb.controller
 * @ClassName: UserController
 * @Description: This is UserController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-14 17:24
 */
@RestController
@RequestMapping("/v1/api/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/create")
    public MyResult create(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setState(1);
        user.setAddTime(new Date());
        if (userDao.insertOne(user) > 0) {
            return new MyResult(200, "success", user.getId());
        } else {
            return new MyResult(500, "fail");
        }
    }

    @RequestMapping("/delete")
    public MyResult delete(long id) {
        User user = new User();
        user.setId(id);
        if (userDao.deleteOne(user) > 0) {
            return new MyResult(200, "success");
        } else {
            return new MyResult(500, "fail");
        }

    }

    @RequestMapping("/update")
    public MyResult update(long id, String username, String password) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        if (userDao.updateOne(user) > 0) {
            return new MyResult(200, "success");
        } else {
            return new MyResult(500, "fail");
        }
    }

    @RequestMapping("/select")
    public MyResult select(long id) {
        User user = new User();
        user.setId(id);
        user = userDao.selectOne(user);
        if (user != null) {
            return new MyResult(200, "success", user);
        } else {
            return new MyResult(500, "fail");
        }
    }

    @RequestMapping("/list")
    public MyResult list() {
        return new MyResult(200, "success", userDao.list(new User()));
    }
}

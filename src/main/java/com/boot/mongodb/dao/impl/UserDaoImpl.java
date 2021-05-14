package com.boot.mongodb.dao.impl;

import com.boot.mongodb.dao.UserDao;
import com.boot.mongodb.entity.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @PackageName: com.boot.mongodb.dao.impl
 * @ClassName: UserDaoImpl
 * @Description: This is UserDaoImpl class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-14 17:17
 */
@Component
public class UserDaoImpl implements UserDao {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public int insertOne(User user) {
        user.setId(mongoTemplate.count(new Query(), User.class) + 1);
        user = mongoTemplate.save(user);
        return user != null ? 1 : 0;
    }

    @Override
    public int deleteOne(User user) {
        return (int) mongoTemplate.remove(user).getDeletedCount();
    }

    @Override
    public int updateOne(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update();
        update.set("username", user.getUsername());
        update.set("password", user.getPassword());
        return (int) mongoTemplate.updateFirst(query, update, User.class).getModifiedCount();
    }

    @Override
    public List<User> list(User user) {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User selectOne(User user) {
        return mongoTemplate.findById(user.getId(),User.class);
    }
}

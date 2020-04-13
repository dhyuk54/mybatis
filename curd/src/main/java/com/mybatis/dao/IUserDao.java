package com.mybatis.dao;

import com.mybatis.domain.User;

import java.util.List;

/**
 *
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有操作
     * @return
     */
    public List<User> findAll();

    /**
     * 插入用户信息
     * @param user
     */
    public void saveUser(User user);

    /**
     * 更新操作
     * @param user
     */
    public void updateUser(User user);

    /**
     * 根据ID删除
     * @param userId
     */
    public void deleteUser(Integer userId);
}

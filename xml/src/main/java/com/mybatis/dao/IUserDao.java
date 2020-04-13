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
    List<User> findAll();
}

package com.mybatis.dao;

import com.mybatis.domain.QueryVo;
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

    /**
     * 根据ID 查询用户信息
     * @param uid
     * @return
     */
    public User findById (Integer uid);

    /**
     * 根据名称模糊查询
     * @param username
     * @return
     */
    public List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    public int findTotal();

    /**
     *根据queryVo查询中的条件查询用户信息
     * @param vo
     * @return
     */
    public List<User> findUserByvo(QueryVo vo);
}

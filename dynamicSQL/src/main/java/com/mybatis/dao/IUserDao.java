package com.mybatis.dao;

import com.mybatis.domain.QueryVo;
import com.mybatis.domain.User;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();


    User findById(Integer userId);

    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入参数条件
     * @return user 查询的条件:有可能有用户名,有可能有性别,有可能有地址,还有可能是都有
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据queryvo中提供的id集合,查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);

}

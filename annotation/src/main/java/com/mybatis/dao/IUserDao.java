package com.mybatis.dao;

import com.mybatis.domain.User;
import org.apache.ibatis.annotations.Select;

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
    //使用注解的方式进行SQL查询
    //比起xml配置文件的方式注解的方式更容易开发一些
    @Select("select * from user")
    List<User> findAll();
}

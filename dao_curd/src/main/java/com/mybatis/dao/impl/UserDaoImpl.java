package com.mybatis.dao.impl;

import com.mybatis.dao.IUserDao;
import com.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;


public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;
    //定义有参数的构造方法,创建对象初期传入factory对象
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        List<User> users = session.selectList("com.mybatis.dao.IUserDao.findAll");//参数就是能获取配置信息的key
        //3.释放资源
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用方法实现保存
        session.insert("com.mybatis.dao.IUserDao.saveUser",user);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();
    }

    @Override
    public void updateUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用方法实现更新
        session.update("com.mybatis.dao.IUserDao.updateUser",user);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();
    }

    @Override
    public void deleteUser(Integer userId) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用方法实现更新
        session.update("com.mybatis.dao.IUserDao.deleteUser",userId);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();
    }

    @Override
    public User findById(Integer userId) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现查询一个
        User user = session.selectOne("com.mybatis.dao.IUserDao.findById",userId);
        //3.释放资源
        session.close();
        return user;
    }

    @Override
    public List<User> findByName(String username) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        List<User> users = session.selectList("com.mybatis.dao.IUserDao.findByName",username);
        //3.释放资源
        session.close();
        return users;
    }

    @Override
    public int findTotal() {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现查询一个
        Integer count = session.selectOne("com.mybatis.dao.IUserDao.findTotal");
        //3.释放资源
        session.close();
        return count;
    }
}

package com.mybatis.test;

import com.mybatis.dao.IUserDao;
import com.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before //用于在测试方法执行之前执行
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        sqlSession = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After //用于在测试方法执行之后执行
    public void destroy() throws IOException {
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll()  {
        List<User> users = userDao.findAll();
        //遍历user对象信息
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存数据
     *
     */
    @Test
    public void testSave() throws IOException {
        User user = new User();
        user.setUsername("mybatis last insertid");
        user.setAddress("东京涉谷");
        user.setSex("女");
        user.setBirthday(new Date());
        System.out.println("保存操作之前"+ user);
        //执行保存登录方法
        userDao.saveUser(user);
        System.out.println("保存操作之后"+ user);
    }

    /**
     * 测试更新操作
     *
     */
    @Test
    public void testUpdate()  {
        User user = new User();
        user.setId(50);
        user.setUsername("mybatis last insertid");
        user.setAddress("東京涉谷区");
        user.setSex("女");
        user.setBirthday(new Date());
        //执行更新方法
        userDao.updateUser(user);

    }

    /**
     * 测试删除操作
     *
     */
    @Test
    public void testDelete()  {
        //执行删除方法
        userDao.deleteUser(48);
    }

    /**
     * 测试查询id操作
     *
     */
    @Test
    public void testFindeOne()  {
        //执行查询一个方法
        User user = userDao.findById(50);
        System.out.println(user);
    }

    /**
     * 测试模糊查询操作
     *
     */
    @Test
    public void testFindeByName()  {
        //执行查询一个方法
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询总记录条数
     *
     */
    @Test
    public void testFindeTotal()  {
        //执行查询一个方法
        int total = userDao.findTotal();
        System.out.println(total);
    }
}


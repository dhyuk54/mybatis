# mybatis 配置环境注意事项
  1.第一步:创建maven工程并导入相应坐标(依赖)  
  2.第二步:创建实体类和dao的接口  
  3.第三步:创建Mybatis的主配置文件(SqlMapConfig.xml)  
  4.第四步:创建映射配置文件(IUserDao.xml)  
    1.此文件会配置一些SQL语句等  
  
# 环境搭建的注意事项:  
   1.创建IUserDao.xml和IUserDao.java名称需保持一致  
   2.在Mybatis中持久层的操作接口名称和映射文件也叫做:Mapper所以 IUserDao和IUserMapper是一样的  

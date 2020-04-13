# mybatis 配置环境注意事项
  1.第一步:创建maven工程并导入相应坐标(依赖)  
  2.第二步:创建实体类和dao的接口  
  3.第三步:创建Mybatis的主配置文件(SqlMapConfig.xml)  
  4.第四步:创建映射配置文件(IUserDao.xml)  
    1.此文件会配置一些SQL语句等  
  
# 环境搭建的注意事项:  
   1.创建IUserDao.xml和IUserDao.java名称需保持一致    
   2.在Mybatis中持久层的操作接口名称和映射文件也叫做:Mapper所以 IUserDao和IUserMapper是一样的    
   3.mybatis的映射配置文件位置必须和dao接口的包结构相同  
   4.映射配置文件的mapper标签namespace属性的取值必须是dao接口的权限定类名  
   5.映射配置文件的操作配置(select),id的属性取值必须是dao接口的方法名一致  
   # 当遵从好3,4,5点之后,在开发中就无须在写dao的实现类.

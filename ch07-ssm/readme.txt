07项目ssm整合开发
ssm ：springMVC视图层【接收请求】
     +spring业务层 管理service ，dao，工具类对象【调用service处理业务逻辑】
     +mybatis 持久层 访问数据库【处理数据】
整合：也叫SSI【ibatis是mybatis前身】
     涉及到容器的问题：springmvc【管理控制器对象的】 <--> spring【管理service，dao工，具类对象】
     两个容器如何产生联系【spring与springmvc关系【子容器：Controller访问Service】以确定好】
     以注解为主/配置标签为辅

实现步骤：
1使用springdb的student表（id自增/name/age）
2pom.xml加入依赖项
     spring
     springmvc
     mybatis
     jackson
     MySQL驱动
     数据库连接池
     jsp[core/bind]
     servlet
3web.xml中进行注册
    DispatcherServlet[中央调度器]：1.创建调度servlet处理请求2.创建springmvc容器对象
    ContextLoaderListener[监听器]   创建spring容器对象 用于创建dao，service对象
    [字符集过滤器] 解决post请求字符集 中文乱码的问题
4目录：controller-service-dao
5容器的配置文件.xml
    springmvc.xml[dispatcherServlet.xml]
    applicationContext.xml
    mybatis.xml
    数据库属性配置文件
6代码实现：增删改查
    持久层：dao接口与SQLMapper.xml
    业务层：service接口与其实现类
    视图层：controller类
    实体类：表模型描述
    webapp：jsp页面

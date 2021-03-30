异常处理:
处理步骤：
1maven
2依赖
3新建一个自定义异常类myUserException，其子类NameException，AgeException
5创建一个普通类做为全局异常处理类
    类上@ControllerAdivice
    类中定义方法，方法上加入@ExceptionHandler

4在控制器类中抛出子类异常
6处理异常的视图页面
7创建springmvc.xml中 组件扫描器扫描创建控制器的注解 与 控制器通知注解的所在的包名
    声明一个注解驱动
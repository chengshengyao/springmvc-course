需求：用户在页面发起一个请求，请求交给springMVC的控制器对象，并显示请求的处理结果【在结果页面显示一个欢迎语句】
1.新建web Maven共工程
2.加入依赖
    spring-webMVC依赖项
    jsp，servlet依赖项
3.重点：web.xml文件中 注册springmvc框架的核心对象 DispatcherServlet【中央调度器/前端控制器】
                    负责接收用户提交的请求，它调用其他控制器对象，并把请求的结果显示给用户
4.创建一个发起请求的页面 index.jsp
5.创建控制器类
    在类的上方加入@Controller注解，创建对象，放入springMVC容器中
    在类的上方加入@RequestMapping注解
6创建一个作为结果的jsp，显示请求的处理结果
7.创建springmvc的配置文件
    声明组件扫描器，指定@Controller注解所在的包名
    声明视图解析器，帮助处理视图的


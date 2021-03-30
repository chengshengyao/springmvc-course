处理器方法的返回值表示请求的处理结果
1.ModelAndView：有数据和视图，对视图执行forward
2.String表示视图，可以使用逻辑名称，也可以是完整的视图路径
3.Void不能表示数据也不表示视图【在处理ajax时，可以使用void返回值 通过Response输出数据，响应异步请求】
                                异步请求是服务器返回数据与视图无关

4.object:例如String，Integer，Map，Student等都是对象。对象有属性，属性就是数据，所以可以返回
object表示数据，与视图无关。可以使用对象表示的数据响应ajax请求。

    实现步骤：1加入处理json工具库的依赖，springmvc默认使用jackson
            2在springmvc的配置文件中加入一个标签，<mvc:annotation-driven>注解驱动
            3.在处理器方法上加入@ResponseBody注解
            实现原理：springmvc处理器方法返回object，返回json输出至浏览器，响应ajax请求
                    <mvc:annotation-driven>注解驱动 完成java对象到json，xml，text数据格式的转换
                    HttpMessageConverter接口：消息转换器 的【接口实现类7个】完成 java对象的格式转换

                    ！boolean canWrite(Class<?> var1, @Nullable MediaType var2);
                    [检查处理器方法返回值可否转为var2表示的数据格式]

                    ！void write(T var1, @Nullable MediaType var2, HttpOutputMessage var3) throws IOException, HttpMessageNotWritableException;
                    [将处理器方法的返回值对象转化为对应的数据格式]




注意：在提交请求参数时，get请求方式 中文无乱码
                    post请求方式 中文有乱码
                    使用过滤器处理乱码的问题【可自定义也可使用框架中提供的过滤器CharacterSetEncodingFilter】


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


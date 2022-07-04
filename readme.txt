cloud2020项目就是一个本地工作空间

请求Exception：
1.Required request body is missing 解决方法：
    1.1.直接调用provider方法服务，方法参数注解@RequestBody，需要请求体传参
    方法参数注解传参，用Postman-Body-json形式传参
    1.2.consumer调用provider方法(带有@ResponseBody传参)，
    直接用postman-params-(key-value键值对)


    //直接调用provider服务方法传@ResponseBody参数只传了serial值，但也能返回payment对象id在数据库中对应值，如下
        /*{
            "code": 200,
                "message": "插入数据库成功,server.port:8001",
                "data": {
                "id": 35,
                "serial": "7190"
            }
        }*/
		
	//如consumer,间接调用provider服务方法只传@ResponseBody参数只传了serial值，没传值为null，如下：
	    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        System.out.println(payment);   //Payment(id=null, serial=7191),与直接调用provider服务方法(@ResponseBody参数)
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }


Ribbon的负载均衡和Rest调用
	Ribbon不用引入，已经存在于下方的以来中：
	        <!--Eureka整合ribbon具有客户端的软负载均衡的能力-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>


面试：
	负载均衡，有没有写过，换过
	轮询负载均衡
	
	
	12-15自旋锁：https://www.bilibili.com/video/BV1jE411h7MR?spm_id_from=333.337.search-card.all.click&vd_source=a624d5626dc0011dc56bfc4cc466feb4
	

有👉Hystrix框架对服务限流进行保护？
Jmeter高并发请求访问，tomcat线程池默认10个工作线程，某个资源访问过大资源都被抽调给那个资源，没有多余的线程来分解压力和处理,导致访问同一个微服务其他接口地址，系统卡顿变慢。消费端不满意，服务端被拖死。
	
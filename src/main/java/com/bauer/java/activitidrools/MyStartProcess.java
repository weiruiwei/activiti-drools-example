package com.bauer.java.activitidrools;

import org.activiti.engine.RuntimeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyStartProcess {

    /**
     * 启动测试
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring-activiti.xml");
        RuntimeService runtimeService  = (RuntimeService)applicationContext.getBean("runtimeService");
        Map<String ,Object> param = new HashMap<>();
        runtimeService.startProcessInstanceByKey("demo","123",param);

    }
}

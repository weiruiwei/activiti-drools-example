package com.bauer.java.activitidrools.task;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * @Author ：rui.wei
 * @Date ：Created in 17:04 2018/8/27
 * @Description： 输出流程走了哪条分支
 */
public class AgeUp implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("age > 20");
    }
}

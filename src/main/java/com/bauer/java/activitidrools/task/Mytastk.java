package com.bauer.java.activitidrools.task;

import com.bauer.java.activitidrools.bean.UserBean;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * @Author ：rui.wei
 * @Date ：Created in 16:43 2018/8/27
 * @Description： 流程中添加入参
 */
public class Mytastk implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        UserBean userBean =  new UserBean();
        userBean.setAge(21);
        userBean.setName("hehe");
        execution.setVariable("userBean",userBean);
    }
}

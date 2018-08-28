package com.bauer.java.activitidrools.task;

import org.activiti.engine.delegate.DelegateExecution;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Component;

/**
 * @Author ：rui.wei
 * @Date ：Created in 10:31 2018/8/28
 * @Description：
 */
@Component("bussinuessRuleTask")
public class BussinuessRuleTask {

    /**
     *
     * @param execution
     * @param name 用于区分触发哪些规则  sessionname
     */
    public void fireRule(String name , DelegateExecution execution ) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
        KieSession kieSession = kContainer.newKieSession(name);
        //插入入参
        kieSession.insert(execution.getVariable("userBean"));
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println("rule has fired");
    }
}

package com.bauer.java.activitidrools.drools;

import com.bauer.java.activitidrools.MyStartProcess;
import javax.annotation.PostConstruct;
import org.apache.commons.io.IOUtils;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.model.KieBaseModel;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.builder.model.KieSessionModel;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author ：rui.wei
 * @Date ：Created in 10:35 2018/8/28
 * @Description：
 */
@Component
public class DroolsLoader {

    /**
     * drools脚本动态生成  可以根据业务，在不同场景下去生成
     * @throws IOException
     */
    @PostConstruct
    public void init() throws IOException {
        KieServices kieServices = KieServices.Factory.get();
        KieModuleModel kieModuleModel = kieServices.newKieModuleModel();
        KieBaseModel kieBaseModel = kieModuleModel.newKieBaseModel("Test");
        KieSessionModel kieSessionModel = kieBaseModel.newKieSessionModel("sdfasdf");
        KieFileSystem kfs = kieServices.newKieFileSystem();
        //读取事先定义好的脚本    可以在此处动态生成脚本
        String ruleTemplate = IOUtils
                .toString(MyStartProcess.class.getResourceAsStream("/drools/user.drl"),  "UTF-8");
        kfs.write("src/main/resources/drools/hello.drl",ruleTemplate);
        kfs.writeKModuleXML(kieModuleModel.toXML());
        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
    }
}

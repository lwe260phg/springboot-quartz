package com.example.quartztest.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @Author :
 * @CreateTime :
 * @Description :
 **/
@Component
public class JobFactory extends AdaptableJobFactory {

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle)
            throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        //Job实例注入到Job工厂
        beanFactory.autowireBean(jobInstance);
        return jobInstance;
    }

}

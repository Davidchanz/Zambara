package org.bubus.zambara.bpp;

import org.bubus.zambara.annotation.Component;
import org.bubus.zambara.annotation.Scope;
import org.bubus.zambara.bean.Bean;
import org.bubus.zambara.bean.BeanDefinition;

@Component
public class ScopeBeanPostProcessor implements BeanPostProcessor{
    @Override
    public BeanDefinition preConstruct(BeanDefinition beanDefinition) throws Exception {
        Class<?> clazz = beanDefinition.getClazz();
        Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
        if(scopeAnnotation != null){
            String scopeValue = scopeAnnotation.value();
            beanDefinition.setScope(scopeValue);
        }else {
            beanDefinition.setScope("singleton");
        }
        return beanDefinition;
    }

    @Override
    public Bean postConstruct(Bean bean) throws Exception {
        return bean;
    }
}

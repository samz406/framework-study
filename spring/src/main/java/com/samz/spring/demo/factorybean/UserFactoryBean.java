package com.samz.spring.demo.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author: lilin
 * @Date: 2022/5/13 17:09
 * @Description: 工厂bean的创建。通过类型或bean拿去的对象 getObject()方法返回值。不是factoryBean对象本身
 * 获取 FactoryBean本身需加一个前缀$
 *
 *
 */
@Component
public class UserFactoryBean implements FactoryBean<User> {

    /**
     *  这是FactoryBean 的注释
     *
     * Used to dereference a {@link FactoryBean} instance and distinguish it from
     * beans <i>created</i> by the FactoryBean. For example, if the bean named
     * {@code myJndiObject} is a FactoryBean, getting {@code &myJndiObject}
     * will return the factory, not the instance returned by the factory.
     *     String FACTORY_BEAN_PREFIX = "&";
     */

    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }


}

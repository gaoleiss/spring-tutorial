package me.gaolei.tutorial.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by lei on 15/04/14.
 * <p/>
 * The BeanPostProcessor interface defines callback methods that you can implement to
 * provide your own (or override the container's default) instantiation logic,
 * dependency-resolution logic, and so forth. If you want to implement some custom logic
 * after the Spring container finishes instantiating, configuring, and initializing a bean,
 * you can plug in one or more BeanPostProcessor implementations.
 */
public class ReadingBookProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("before init: login ebay");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("after init: logout ebay");
        return o;
    }
}

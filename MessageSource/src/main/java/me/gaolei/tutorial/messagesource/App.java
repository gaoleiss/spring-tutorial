package me.gaolei.tutorial.messagesource;

import me.gaolei.tutorial.messagesource.services.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;


public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

        //get the message resource inside context
        String name = context.getMessage("customer.name",
                new Object[]{28, "http://gaolei.me"}, Locale.getDefault());
        System.out.println("Customer name (English) : " + name);

        String namechinese = context.getMessage("customer.name",
                new Object[]{28, "http://gaolei.me"}, Locale.SIMPLIFIED_CHINESE);
        System.out.println("Customer name (Chinese) : " + namechinese);

        //get the message resource inside the bean
        CustomerService cust = (CustomerService) context.getBean("customerService");
        cust.printMessage();
    }
}

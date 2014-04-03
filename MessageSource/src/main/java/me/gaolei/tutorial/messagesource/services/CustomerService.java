package me.gaolei.tutorial.messagesource.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class CustomerService {

    @Autowired
    private MessageSource messageSource;


    public void printMessage() {
        String name = messageSource.getMessage("customer.name",
                new Object[]{28, "http://gaolei.me"}, Locale.US);
        System.out.println("Customer name (English) : " + name);


        String namechinese = messageSource.getMessage("customer.name",
                new Object[]{28, "http://gaolei.me"}, Locale.SIMPLIFIED_CHINESE);
        System.out.println("Customer name (Chinese) : " + namechinese);
    }

}

package me.gaolei.tutorial;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

/**
 * Created by lei on 15/04/14.
 */
public class BookTest {
    @Test
    public void test() throws Exception {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        Book book = context.getBean(Book.class);
        Assert.notNull(book);
        System.out.println("book info:\t" + book);
        context.close();
    }
}

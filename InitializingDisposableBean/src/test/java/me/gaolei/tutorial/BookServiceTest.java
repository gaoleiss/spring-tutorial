package me.gaolei.tutorial;

/**
 * Created by lei on 10/04/14.
 */

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookServiceTest {
    private static BookService bookService;
    private static ConfigurableApplicationContext context;

    @BeforeClass
    public static void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        bookService = (BookService) context.getBean("bookService");
    }

    @Test
    public void test() {
        Book book = bookService.getBook();
        Assert.assertNotNull(book);
        System.out.println("reading book:\t" + book.getTitle());
    }

    @AfterClass
    public static void destroy() {
        context.close();
    }
}

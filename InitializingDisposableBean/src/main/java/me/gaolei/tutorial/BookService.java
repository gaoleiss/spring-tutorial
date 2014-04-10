package me.gaolei.tutorial;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by lei on 10/04/14.
 */
public class BookService implements InitializingBean, DisposableBean {
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("before reading");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("after reading");
    }
}

package io.github.danielpine.springcachedemo.dao;


import io.github.danielpine.springcachedemo.po.Book;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {

    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    @Override
    @CacheEvict("books")
    public void removeByIsbn(String isbn) {

    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 1000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}

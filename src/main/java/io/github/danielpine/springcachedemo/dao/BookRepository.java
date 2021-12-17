package io.github.danielpine.springcachedemo.dao;


import io.github.danielpine.springcachedemo.po.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);

    void removeByIsbn(String isbn);

}

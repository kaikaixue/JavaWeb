package com.xkk.mapper;

import com.xkk.domain.DO.Book;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookDB {
    private static Map<String , Book> books = new LinkedHashMap<>();
    static {
        books.put("1", new Book("1", "JavaWeb开发"));
        books.put("2", new Book("2", "jdbc开发"));
        books.put("3", new Book("3", "java基础"));
        books.put("4", new Book("4", "struts开发"));
        books.put("5", new Book("5", "spring开发"));
    }

    // 获得所有的图书
    public static Collection<Book> getAll() {
        return books.values();
    }

    // 根据制定的id获得图书
    public static Book getBook(String id) {
        return books.get(id);
    }
}

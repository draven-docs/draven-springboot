package com.noxus.draven.caching.ehcache.based.entity;

/**
 * 〈功能概述〉<br>
 *
 * @className: Book
 * @package: com.noxus.draven.caching.ehcache.based.entity
 * @author: draven
 * @date: 2020/12/21 16:28
 */
public class Book {

    private String name;

    private String author;

    private Float price;

    public Book() {

    }

    public Book(String name, String author, Float price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}

package com.noxus.draven.caching.ehcache.based.controller;

import com.noxus.draven.caching.ehcache.based.entity.Book;
import com.thoughtworks.xstream.XStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 〈功能概述〉<br>
 *
 * @className: DevtoolsApi
 * @package: com.noxus.draven.caching.ehcache.based.devtools
 * @author: draven
 * @date: 2020/12/21 16:26
 */
@RestController
@RequestMapping("devtools")
public class DevtoolsApi {

    @GetMapping("msg")
    public String getMsg() {
        return "Hello devtools, I love You";
    }

    @GetMapping("cast")
    public void cast() {
        String xml = "<book><name>xstream</name></book>";
        XStream xstream = new XStream();
        // 指定xtream的classloader，否则会报转换异常
        xstream.setClassLoader(Book.class.getClassLoader());
        xstream.alias("book", Book.class);
        Book book = (Book) xstream.fromXML(xml);
        System.out.print(book.getName());
    }
}

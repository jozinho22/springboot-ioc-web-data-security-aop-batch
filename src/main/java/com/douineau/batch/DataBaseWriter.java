package com.douineau.batch;

import com.douineau.dao.api.IBookDao;
import com.douineau.model.api.Book;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataBaseWriter implements ItemWriter<Book> {

    @Autowired
    private IBookDao dao;

    @Override
    public void write(List<? extends Book> books) throws Exception {
        System.out.println("write(List<? extends Book> books) throws Exception {");
        System.out.println(books);
        dao.saveAll(books);
    }
}

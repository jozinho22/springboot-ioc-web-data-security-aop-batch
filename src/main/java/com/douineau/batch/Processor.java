package com.douineau.batch;

import com.douineau.model.api.Book;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<Book, Book> {

    @Override
    public Book process(Book book) throws Exception {
        System.out.println("process(Book book) throws Exception {");
        System.out.println(book);
        return book;
    }
}

package com.book.api.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.api.bootrestbook.dao.BookRepository;
import com.book.api.bootrestbook.entities.Book;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    // private static List<Book> list = new ArrayList<>();

    // static {
    // list.add(new Book(1001, "Java", "Rahul"));
    // list.add(new Book(1002, "Python", "Sachin"));
    // list.add(new Book(1003, "C", "Dipak"));

    // }

    public List<Book> getAllBooks() {

        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    public Book getBookById(int id) {
        Book book = null;
        try {
            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book addbook(Book b) {
        // list.add(b);
        Book result = bookRepository.save(b);
        return result;
    }

    public void deleteBook(int id) {
        // list = list.stream().filter(book -> book.getId() !=
        // id).collect(Collectors.toList());
        bookRepository.deleteById(id);
    }

    public void updateBook(Book book, int id) {
        // list = list.stream().map(b -> {
        // if (b.getId() == id) {
        // b.setTitle(book.getTitle());
        // b.setAuthor(book.getAuthor());
        // }
        // return b;
        // }).collect(Collectors.toList());
        book.setId(id);
        bookRepository.save(book);
    }
}

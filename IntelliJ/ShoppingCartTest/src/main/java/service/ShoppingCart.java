package service;

import Books.Book;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ShoppingCart {

    List<Book> books;
    public void add(Book b1) {
        books.add(b1);
    }

    public int getTotal() {
        AtomicInteger total = new AtomicInteger();
        books.forEach(b-> {
            total.addAndGet(b.getPrice());
        });
        return total.get();
    }
}

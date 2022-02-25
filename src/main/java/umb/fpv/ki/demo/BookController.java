package umb.fpv.ki.demo;


import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class BookController<autfirstName> {

    List<Book> books;

    public BookController() {
        this.books = init();
    }

    public List<Book> init() {
        List<Book> books = new ArrayList<>();

        Book Book_1 = new Book();
        Book_1.setIsbn("97880755442703");
        Book_1.setAutfirstName("Kiera");
        Book_1.setAutlastName("Cassova");
        Book_1.setTitle("Koruna");
        Book_1.setCount("10");

        Book Book_2 = new Book();
        Book_2.setIsbn("978809972040");
        Book_2.setAutfirstName("Baja");
        Book_2.setAutlastName("Dolce");
        Book_2.setTitle("Habibi");
        Book_2.setCount("15");

        Book Book_3 = new Book();
        Book_3.setIsbn("9788022206846");
        Book_3.setAutfirstName("Rick");
        Book_3.setAutlastName("Yancey");
        Book_3.setTitle("Piata clna");
        Book_2.setCount("8");

        return books;

    }

    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String autfirstName) {


        if (autfirstName == null) {
            return this.books;
        }

        List<Book> f_Books = new ArrayList<>();
        for (Book book : books) {

            String bookautfirstName = null;
            if (book.getAutfirstName().equals(bookautfirstName)) {
                f_Books.add(book);
            }
        }
        return f_Books;

    }

    @GetMapping("/api/bookIsbn")
    public List<Book> getBooksIsbn(@RequestParam(required = false) String bookIsbn) {
        if (bookIsbn == null) {
            return this.books;
        }
        List<Book> f_Books = new ArrayList<>();
        for (Book book : books) {
            if (book.getIsbn().equals(bookIsbn)) {
                f_Books.add(book);
            }
        }
        return f_Books;

    }

    @PostMapping("/api/book")
    public List<Book> create_Book(@RequestBody Book book) {
        this.books.add(book);
        return books;
    }

    @DeleteMapping("/api/book")
    public void delete_Book(@PathVariable Integer bookIsbn) {
        this.books.remove(this.books);
    }

    @PutMapping("api/book{bookIsbn}")
    public List<Book> put_Book(@PathVariable Integer bookIsbn, @RequestBody Book book) {
        this.books.get(bookIsbn).setCount(book.getCount());
        this.books.get(bookIsbn).setAutfirstName(book.getAutfirstName());
        this.books.get(bookIsbn).setAutlastName(book.getAutlastName());
        this.books.get(bookIsbn).setTitle(book.getTitle());
        this.books.get(bookIsbn).setIsbn(book.getIsbn());
        return books;
    }
}
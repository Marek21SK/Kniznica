package umb.fpv.ki.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

    private final List <Book> books = new ArrayList<>();

    @GetMapping("/books")
    public List <Book> get(){

       /// List <Book> books = new ArrayList<Book>();
        /// books.add(new Book("Lord of the rings"));
        // /// books.add(new Book("Harry Potter"));
        return books;
    }

   /// @GetMapping("/books/{bookId}")
   /// public Book getBookById(@PathVariable Integer boookId, @RequestParam String bookName){
   ///     return new Book("Lord of the Rings");
   /// }

    @PostMapping("/books")
    public Book create(@RequestBody Book book){
        books.add(book);
        return book;
    }

    @PostMapping("/books/by-name")
    public Book create(@RequestParam String name){
        Book book = new Book();
        book.name = name;
        books.add(book);
        return book;
    }

}

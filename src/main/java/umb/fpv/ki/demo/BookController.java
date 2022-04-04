package umb.fpv.ki.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {




    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    //List of book
    @GetMapping ("/api/books")
    public List<BookDto> getBook (@RequestParam(required = false) String bookAuthor) {
        return bookService.getBooks(bookAuthor);
    }
    //Update of book
    @PutMapping("/api/books/{bookId}")
    public void updateBook(@PathVariable int bookId, @RequestBody BookDto book){
        bookService.updateBook(bookId, book);
    }
// Get book by id
    @GetMapping("/api/bookId")
    public BookDto getBook(@PathVariable int bookId){
        return bookService.getBook((long) bookId);
    }

    //Create book
    @PostMapping("/api/books")
    public String createBook(@RequestBody BookDto book){
        return bookService.createBook(book);
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable int  bookId){
        bookService.deleteBook(bookId);
    }

}

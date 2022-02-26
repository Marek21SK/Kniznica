package umb.fpv.ki.demo;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books;

    public BookService(){
        this.books = init();
    }

    private List<Book> init(){
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
        Book_3.setTitle("Piata vlna");
        Book_2.setCount("8");

        return books;
    }

    public List<Book> getBooks(String bookAutfirstName){
        if(bookAutfirstName==null){
            return this.books;
        }

        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books){
            if (book.getAutfirstName().equals(book.getAutfirstName())){
                filteredBooks.add(book);
            }
        }

        return filteredBooks;

    }

    public void deleteBook(int bookId){

        this.books.remove(this.books.get(bookId));
    }

    public void updateBook(int bookId, Book book){
        this.books.get(bookId).setTitle(book.getTitle());
        this.books.get(bookId).setAutfirstName(book.getAutfirstName());
    }

    public Book getBook(int bookId){
        return this.books.get(bookId);
    }

    public Integer createBook(Book book){
        this.books.add(book);
        return this.books.size()-1;
    }


}


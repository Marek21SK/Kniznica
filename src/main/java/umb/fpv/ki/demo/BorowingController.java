package umb.fpv.ki.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BorowingController{
    List<Borrowing> borrowings;

    public BorowingController(){
        this.borrowings = init_1();
    }

    public List<Borrowing> init_1(){
        List<Borrowing> borrow = new ArrayList<>();

        Borrowing borrowing1 = new Borrowing();
        borrowing1.setBorrowingId("1");
        borrow.add(borrowing1);

        Borrowing borrowing2 = new Borrowing();
        borrowing2.setBorrowingId("2");
        borrow.add(borrowing2);

        return borrow;
    }


    @GetMapping("/api/borrowings")
    public List<Borrowing> getBorrowing(@RequestParam(required = false) String borrowingId){
        if(borrowingId == null){
            return this.borrowings;
        }

        List<Borrowing> f_Borrowings = new ArrayList<>();

        for (Borrowing borrowings : borrowings){
            if(borrowings.getBorrowingId().equals(borrowingId)){
                f_Borrowings.add(borrowings);
            }
        }

        return f_Borrowings;
    }


    @PostMapping("api/borrowings")
    public  List<Borrowing> create_Borrowing(@RequestBody Borrowing borrowing){
        this.borrowings.add(borrowing);

        return borrowings;
    }


    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void delete_Borrowing(@PathVariable Integer borrowingId){
        this.borrowings.remove(this.borrowings.get(borrowingId));
    }
}
package umb.fpv.ki.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BorrowingController{
    private List<Borrowing> borrowing;

    private BorrowingService borrowingService;
    public BorrowingController(BorrowingService borrowingService){
        this.borrowingService = borrowingService;
    }


    @GetMapping("/api/borrowings")
    public List<Borrowing> getBorrowing(@RequestParam(required = false) String borrowingId){
        return this.borrowingService.getBorrowings(borrowingId);
    }


    @PostMapping("api/borrowings")
    public  List<Borrowing> createBorrowing(@RequestBody Borrowing borrowing){
        return borrowingService.createBorrowing(borrowing);

    }


    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void delete_Borrowing(@PathVariable Integer borrowingId){
        this.borrowingService.deleteBorrowing(borrowingId);
    }
}
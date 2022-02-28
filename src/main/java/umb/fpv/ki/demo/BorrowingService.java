package umb.fpv.ki.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowingService{
    private final List<Borrowing> borrowing;

    public BorrowingService(){
        this.borrowing = init();
    }

    public List<Borrowing> init(){
        List<Borrowing> borrow = new ArrayList<>();
        Borrowing borrow1 = new Borrowing();
        borrow1.setBorrowingId("1");
        borrow.add(borrow1);
        return borrow;
    }
    public List<Borrowing> getBorrowings(String borrowingId){
        if(borrowingId == null){
            return this.borrowing;
        }
        List<Borrowing> Borrowings = new ArrayList<>();
        for (Borrowing borrowing : borrowing){
            if(borrowing.getBorrowingId().equals(borrowingId)){
                Borrowings.add(borrowing);
            }
        }
        return Borrowings;
    }
    public  List<Borrowing> createBorrowing(Borrowing borrow){
        this.borrowing.add(borrow);
        return borrowing;
    }
    public void deleteBorrowing(int borrowId){
        this.borrowing.remove(this.borrowing.get(borrowId));
    }
}
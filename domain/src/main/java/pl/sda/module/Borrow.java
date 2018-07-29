package pl.sda.module;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Created by MCK on 21.07.2018 12:42
 **/
@Getter
@Setter
public class Borrow {

    private Long borrowId;
    private LocalDate borrowDate;
    private Long borrowerId;
    private Long bookId;
    private LocalDate backDate;
    private boolean borrowFlag;

    public Borrow() {
    }

/*    public Borrow(LocalDate borrowDate, Long borrowerId, Long bookId) {
        this.borrowDate = borrowDate;
        this.borrowerId = borrowerId;
        this.bookId = bookId;
    }

    public Borrow(Long borrowId, LocalDate borrowDate, Long borrowerId, Long bookId) {
        this.borrowId = borrowId;
        this.borrowDate = borrowDate;
        this.borrowerId = borrowerId;
        this.bookId = bookId;
    }*/

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowId=" + borrowId +
                ", borrowDate=" + borrowDate +
                ", borrowerId=" + borrowerId +
                ", bookId=" + bookId +
                '}';
    }
}

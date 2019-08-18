package com.liangx.practice.booksystem.entity;

import java.util.Date;

public class BorrowedTable extends BorrowedTableKey {
    private Date borrowedDate;

    private Date returnDate;

    public BorrowedTable(String bookId, String cardId, Date borrowedDate, Date returnDate) {
        super(bookId, cardId);
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
    }

    public BorrowedTable() {
        super();
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
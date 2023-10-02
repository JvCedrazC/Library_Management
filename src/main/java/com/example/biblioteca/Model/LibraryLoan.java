package com.example.biblioteca.Model;

import com.example.biblioteca.DAO.bookDAO.BookDAO;

import java.time.LocalDate;
import java.util.ArrayList;

public class LibraryLoan {
    private int libraryLoanId;
    private int customerID;
    private int bookID;
    private int bookISBN;
    private LocalDate startDate;
    private LocalDate finishDate;
    private int extendsNumbers = 0;
    private Float tax = 0.0F;
    private BookDAO bookDAO;


    public LibraryLoan(int customerID, int ISBN){
        setCustomerID(customerID);
        setBookISBN(ISBN);
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setBookISBN(int bookISBN) {
        this.bookISBN = bookISBN;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setLibraryLoanId(int libraryLoanId) {
        this.libraryLoanId = libraryLoanId;
    }

    public int getLibraryLoanId() {
        return libraryLoanId;
    }

    public int getBookISBN() {
        return bookISBN;
    }

    public int getBookID() {
        return bookID;
    }
    public LocalDate getFinishDate(){
        return this.finishDate;
    }

    public void make_loan(int bookISBN){
        ArrayList<Book> newBook = bookDAO.findBYISBN(bookISBN);
        for (Book i: newBook){
            if (i.getLocked() == 0){
                i.setLocked(1);
                bookDAO.update(i);
                setBookID(i.getId());
                startDate = LocalDate.now();
                finishDate = startDate.plusDays(7);
                break;
            }
            //Exception
        }
    }

    public void extend_loan(){
        if (extendsNumbers <= 3){
            this.finishDate = this.finishDate.plusDays(7);
        }
        //Exception
        //Counter
        extendsNumbers += 1;
    }

    public Float getTax(LocalDate devolutionDate){
        return null;
    }


    public boolean isDelayed(LocalDate devolutionDate){
        if (devolutionDate.isAfter(getFinishDate())){
            return true;
        } else{
            return false;
        }
    }


}

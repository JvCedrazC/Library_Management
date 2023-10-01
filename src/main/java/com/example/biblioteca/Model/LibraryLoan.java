package com.example.biblioteca.Model;

import com.example.biblioteca.DAO.bookDAO.BookDAO;

import java.time.LocalDate;
import java.util.ArrayList;

public class LibraryLoan {
    private int libraryLoanId;
    private int customerID;
    private int bookID;
    private LocalDate startDate;
    private LocalDate finishDate;
    private int extendsNumbers = 0;
    private BookDAO bookDAO;


    public LibraryLoan(int customerID){
        setCustomerID(customerID);
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
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

    public void finish_loan(){

    }

    public Float getTax(){
        return null;
    }


    public boolean isDelayed(){
        return false;
    }


}

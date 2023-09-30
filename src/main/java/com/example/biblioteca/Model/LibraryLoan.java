package com.example.biblioteca.Model;

import com.example.biblioteca.DAO.bookDAO.BookDAO;

import java.time.LocalDate;

public class LibraryLoan {
    private int libraryLoanId;
    private int customerID;
    private int bookID;
    private LocalDate startDate;
    private LocalDate finishDate;
    private int extendsNumbers = 0;
    private BookDAO bookDAO;


    public LibraryLoan(int customerID, int bookID){
        setBookID(bookID);
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
        startDate = LocalDate.now();
        finishDate = startDate.plusDays(7);
        Book newBook = bookDAO.findBYISBN(bookISBN);
        newBook.setLocked(1);
        bookDAO.update(newBook);


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


}

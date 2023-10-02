package com.example.biblioteca.Model;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.DAO.bookDAO.BookDAO;
import com.example.biblioteca.DAO.customerDAO.CustomerDAO;

import java.time.LocalDate;
import java.util.ArrayList;

public class Operator extends Person{
    BookDAO bookDAO = DAO.getBook();

    //constructor
    public Operator(int id, String name){
        super(id, name);
    }

    //methods
    public void make_loan(int bookISBN, int customerID){

        LibraryLoan libraryLoan = new LibraryLoan(customerID, bookISBN);
        ArrayList<Book> newBook = bookDAO.findBYISBN(bookISBN);
        for (Book i: newBook){
            if (i.getLocked() == 0){
                i.setLocked(1);
                DAO.getBook().update(i);
                libraryLoan.setBookID(i.getId());
                LocalDate sDate = LocalDate.now();
                LocalDate fDate = sDate.plusDays(7);
                libraryLoan.setFinishDate(fDate);
                libraryLoan.setStartDate(sDate);
                break;
            }
        }
        DAO.getLibraryLoanDAO().create(libraryLoan);
    }

    public void makeBooking(){

    }
    public void newBook(int isbn, String BookName, String publisher, String author, int category_id){
        Book book = new Book(isbn, category_id, BookName, author, publisher);
        bookDAO.create(book);
    }

    public Customer newCustomer(String name){
        CustomerDAO customerDAO = DAO.getCustomer();
        Customer customer = new Customer(-1, name);
        Customer newCustomer = customerDAO.create(customer);
        return newCustomer;
    }

}

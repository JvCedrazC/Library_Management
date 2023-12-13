package com.example.biblioteca.Model;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.DAO.bookDAO.BookDAO;
import com.example.biblioteca.DAO.customerDAO.CustomerDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Operator extends Person{
   // private transient BookDAO bookDAO;

    //constructor
    public Operator(int id, String name){
        super(id, name);
    }
    //methods
    public LibraryLoan make_loan(int bookISBN, int customerID){
        LibraryLoan libraryLoan = new LibraryLoan(customerID, bookISBN);
        ArrayList<Book> newBook = DAO.getBook().findBYISBN(bookISBN);
        for (Book i: newBook){
            if (i.getLocked() == 0){
                i.setLocked(1);
                DAO.getBook().update(i);
                libraryLoan.setBookID(i.getId());
                LocalDate sDate = LocalDate.now();
                LocalDate fDate = sDate.plusDays(7);
                libraryLoan.setFinishDate(fDate);
                libraryLoan.setStartDate(sDate);
                LibraryLoan libraryLoan2 = DAO.getLibraryLoanDAO().create(libraryLoan);
                return libraryLoan2;
            }
        }
        return null;

    }

    public void startBooking(String date, int nDays, Booking booking){
        LocalDate startDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate finishDate = startDate.plusDays(nDays);
        booking.setStartdate(startDate);
        booking.setFinishdate(finishDate);
    }

    public void newBook(int isbn, String BookName, String publisher, String author, int category_id){
        Book book = new Book(isbn, category_id, BookName, author, publisher);
        DAO.getBook().create(book);
    }

    public Customer newCustomer(String name){
        CustomerDAO customerDAO = DAO.getCustomer();
        Customer customer = new Customer(-1, name);
        Customer customer1 = customerDAO.create(customer);
        return customer1;
    }

}

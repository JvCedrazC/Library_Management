package com.example.biblioteca.Model;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.DAO.bookDAO.BookDAO;
import com.example.biblioteca.DAO.customerDAO.CustomerDAO;

public class Operator extends Person{
    BookDAO bookDAO = DAO.getBook();

    //constructor
    public Operator(int id, String name){
        super(id, name);
    }

    //methods
    public void make_loan(int customerID, int ISBN){
        LibraryLoan libraryLoan = new LibraryLoan(customerID);


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

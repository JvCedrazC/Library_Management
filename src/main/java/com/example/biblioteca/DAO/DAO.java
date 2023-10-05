package com.example.biblioteca.DAO;

import com.example.biblioteca.DAO.admDAO.AdmDAO;
import com.example.biblioteca.DAO.admDAO.AdmDAOListImplements;
import com.example.biblioteca.DAO.bookDAO.BookDAO;
import com.example.biblioteca.DAO.bookDAO.BookDAOListImplements;
import com.example.biblioteca.DAO.categoryDAO.CategoryDAO;
import com.example.biblioteca.DAO.categoryDAO.CategoryDAOListImplements;
import com.example.biblioteca.DAO.customerDAO.CustomerDAO;
import com.example.biblioteca.DAO.customerDAO.CustomerDAOListImplements;
import com.example.biblioteca.DAO.libraryLoanDAO.LibraryLoanDAO;
import com.example.biblioteca.DAO.libraryLoanDAO.LybraryLoanDAOListImplements;
import com.example.biblioteca.DAO.operatorDAO.OperatorDAO;
import com.example.biblioteca.DAO.operatorDAO.OperatorDAOListImplements;

public class DAO {
    private static CustomerDAO customerDAO;
    private static BookDAO bookDAO;
    private static OperatorDAO operatorDAO;
    private static LibraryLoanDAO libraryLoanDAO;
    private static AdmDAO admDAO;
    private static CategoryDAO categoryDAO;
    public static CustomerDAO getCustomer(){
        if (customerDAO == null){
            customerDAO = new CustomerDAOListImplements();
        }
        return customerDAO;
    }

    public static BookDAO getBook(){
        if (bookDAO == null){
            bookDAO = new BookDAOListImplements();
        }
        return bookDAO;
    }

    public static OperatorDAO getOperatorDAO(){
        if (operatorDAO == null){
            operatorDAO = new OperatorDAOListImplements();
        }
        return operatorDAO;
    }

    public static LibraryLoanDAO getLibraryLoanDAO(){
        if (libraryLoanDAO == null){
            libraryLoanDAO = new LybraryLoanDAOListImplements();
        }
        return libraryLoanDAO;
    }

    public static AdmDAO getAdmDAO(){
        if (admDAO == null){
            admDAO = new AdmDAOListImplements();
        }
        return admDAO;
    }

    public static CategoryDAO getCategoryDAO(){
        if (categoryDAO == null){
            categoryDAO = new CategoryDAOListImplements();
        }
        return categoryDAO;
    }

}

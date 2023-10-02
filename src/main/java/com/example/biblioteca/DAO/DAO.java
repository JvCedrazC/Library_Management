package com.example.biblioteca.DAO;

import com.example.biblioteca.DAO.bookDAO.BookDAO;
import com.example.biblioteca.DAO.bookDAO.BookDAOListImplements;
import com.example.biblioteca.DAO.customerDAO.CustomerDAO;
import com.example.biblioteca.DAO.customerDAO.CustomerDAOListImplements;
import com.example.biblioteca.DAO.operatorDAO.OperatorDAO;
import com.example.biblioteca.DAO.operatorDAO.OperatorDAOListImplements;

public class DAO {
    public static CustomerDAO customerDAO;
    public static BookDAO bookDAO;
    public static OperatorDAO operatorDAO;
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

}

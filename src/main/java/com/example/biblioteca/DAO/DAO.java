package com.example.biblioteca.DAO;

import com.example.biblioteca.DAO.customerDAO.CustomerDAO;
import com.example.biblioteca.DAO.customerDAO.CustomerDAOListImplements;

public class DAO {
    public static CustomerDAO customerDAO;
    public static CustomerDAO getCustomer(){
        if (customerDAO == null){
            customerDAO = new CustomerDAOListImplements();
        }
        return customerDAO;
    }

}

package com.example.biblioteca.DAO.customerDAO;

import com.example.biblioteca.Model.Customer;
import com.example.biblioteca.DAO.CRUD;
import java.util.List;
public interface CustomerDAO extends CRUD<Customer> {
    public Customer create(Customer customer);
    public Customer findById(int id);
    public List<Customer> findMany();
    //update
    public void update(Customer obj);
    //delete
    public void deleteById(int id);
    public void deleteMany();

}

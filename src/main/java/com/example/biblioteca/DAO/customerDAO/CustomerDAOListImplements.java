package com.example.biblioteca.DAO.customerDAO;

import com.example.biblioteca.Model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAOListImplements implements CustomerDAO{
    private int NextId;
    private ArrayList<Customer> CustomerList;
    public CustomerDAOListImplements(){
        this.NextId = 0;
        this.CustomerList = new ArrayList<Customer>();
    }
    @Override
    public Customer create(Customer customer) {
        customer.setId(NextId);
        NextId++;
        this.CustomerList.add(customer);
        return customer;
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer: this.CustomerList){
            if (customer.getId() == id){
                return customer;
            }
        }
        return null;
    }

    @Override
    public List<Customer> findMany() {
        return null;
    }

    @Override
    public void update(Customer obj) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteMany() {

    }
}

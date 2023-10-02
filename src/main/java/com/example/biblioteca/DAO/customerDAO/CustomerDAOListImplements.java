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
        List<Customer> listcustomer = new ArrayList<Customer>();
        for (Object o: this.CustomerList){
            listcustomer.add((Customer) o);
        }
        return listcustomer;
    }

    @Override
    public void update(Customer obj) {
        for (int i = 0; i < CustomerList.size(); i++){
            if (this.CustomerList.get(i).getId() == obj.getId()){
                this.CustomerList.set(i, obj);
            }
        }

    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < CustomerList.size(); i++){
            if (this.CustomerList.get(i).getId() == id){
                this.CustomerList.remove(i);
            }
        }

    }

    @Override
    public void deleteMany() {
        this.CustomerList = new ArrayList<Customer>();
        this.NextId = 0;
    }
}

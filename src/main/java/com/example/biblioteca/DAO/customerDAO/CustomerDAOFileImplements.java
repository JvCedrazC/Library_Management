package com.example.biblioteca.DAO.customerDAO;

import com.example.biblioteca.FileUtils.ManagingFiles;
import com.example.biblioteca.Model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAOFileImplements implements CustomerDAO{
    private int NextId;
    private ArrayList<Customer> CustomerList;
    private ManagingFiles managingFiles;
    public CustomerDAOFileImplements(){
        this.managingFiles = new ManagingFiles("Customer.bin");
        this.CustomerList = this.managingFiles.retrieve();
        if (this.CustomerList.size() != 0){
            this.NextId = this.CustomerList.size();
        }
        else{
            this.NextId = 0;
        }
    }
    @Override
    public Customer create(Customer customer) {
        customer.setId(NextId);
        NextId++;
        this.CustomerList.add(customer);
        this.managingFiles.save(CustomerList);
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
        this.managingFiles.save(CustomerList);
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < CustomerList.size(); i++){
            if (this.CustomerList.get(i).getId() == id){
                this.CustomerList.remove(i);
            }
        }
        this.managingFiles.save(CustomerList);

    }

    @Override
    public void deleteMany() {
        this.CustomerList = new ArrayList<Customer>();
        this.NextId = 0;
        this.managingFiles.save(CustomerList);
    }
}

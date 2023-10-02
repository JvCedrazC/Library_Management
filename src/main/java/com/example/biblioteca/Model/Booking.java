package com.example.biblioteca.Model;

import java.time.LocalDate;

public class Booking {
    private int customerID;
    private int ISBN;
    private LocalDate startdate;
    private LocalDate finishdate;

    public void setCustomerID(int customerID, int ISBN, String startDate){
        setCustomerID(customerID);
        setISBN(ISBN);
    }
    public void setISBN(int ISBN){
        this.ISBN = ISBN;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void startBooking(String date){
        

    }





}

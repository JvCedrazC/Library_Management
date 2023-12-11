package com.example.biblioteca.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Booking implements Serializable {
    private int bookingID;
    private int customerID;
    private int ISBN;
    private LocalDate startdate;
    private LocalDate finishdate;

    public  Booking(int customerID, int ISBN){
        setCustomerID(customerID);
        setISBN(ISBN);
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setISBN(int ISBN){
        this.ISBN = ISBN;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public void setFinishdate(LocalDate finishdate) {
        this.finishdate = finishdate;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getISBN() {
        return ISBN;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public LocalDate getFinishdate() {
        return finishdate;
    }

}

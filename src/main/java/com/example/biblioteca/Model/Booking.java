package com.example.biblioteca.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Booking {
    private int bookingID;
    private int customerID;
    private int ISBN;
    private LocalDate startdate;
    private LocalDate finishdate;


    public void Booking(int customerID, int ISBN, String startDate, int nDays){
        setCustomerID(customerID);
        setISBN(ISBN);
        startBooking(startDate, nDays);
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

    public void startBooking(String date, int nDays){
        LocalDate startDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate finishDate = startDate.plusDays(nDays);
        setStartdate(startDate);
        setFinishdate(finishDate);
    }

}

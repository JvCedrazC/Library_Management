package com.example.biblioteca.DAO.bookingDAO;

import com.example.biblioteca.Model.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingDAOListImplements implements BookingDAO{
    private ArrayList<Booking> bookinglist;
    private int nextId;

    public BookingDAOListImplements(){
        this.bookinglist = new ArrayList<>();
        this.nextId = 0;
    }

    @Override
    public Booking create(Booking obj) {
        obj.setBookingID(nextId);
        this.bookinglist.add(obj);
        this.nextId++;
        return obj;
    }

    @Override
    public Booking findById(int id) {
        return null;
    }

    @Override
    public List<Booking> findMany() {
        return null;
    }

    @Override
    public void update(Booking obj) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteMany() {

    }
}

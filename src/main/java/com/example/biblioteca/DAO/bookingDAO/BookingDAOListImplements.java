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
        for (Booking booking: this.bookinglist){
            if (booking.getBookingID() == id){
                return booking;
            }
        }
        return null;
    }

    @Override
    public List<Booking> findMany() {
        ArrayList<Booking> listBooking = new ArrayList<>();
        for (Object o: this.bookinglist){
            listBooking.add((Booking) o);
        }
        return listBooking;
    }

    @Override
    public void update(Booking obj) {
        for (int i = 0; i < this.bookinglist.size(); i++){
            if (this.bookinglist.get(i).getBookingID() == obj.getBookingID()){
                this.bookinglist.set(i, obj);
            }
        }
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteMany() {

    }
}

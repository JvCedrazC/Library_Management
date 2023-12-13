package com.example.biblioteca.DAO.bookingDAO;

import com.example.biblioteca.FileUtils.ManagingFiles;
import com.example.biblioteca.Model.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingDAOFileImplements implements BookingDAO{
    private ArrayList<Booking> bookinglist;
    private int nextId;
    private ManagingFiles managingFiles;

    public BookingDAOFileImplements(){
        this.managingFiles = new ManagingFiles("Booking.bin");
        this.bookinglist = this.managingFiles.retrieve();
        if (bookinglist.size() != 0){
            this.nextId = bookinglist.size();
        }
        else{
            this.nextId = 0;
        }
    }

    @Override
    public Booking create(Booking obj) {
        obj.setBookingID(nextId);
        this.bookinglist.add(obj);
        this.managingFiles.save(bookinglist);
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
        this.managingFiles.save(bookinglist);
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < this.bookinglist.size();i++){
            if (this.bookinglist.get(i).getBookingID() == id){
                this.bookinglist.remove(i);
                break;
            }
        }
        this.managingFiles.save(bookinglist);
    }

    @Override
    public void deleteMany() {
        this.bookinglist = new ArrayList<>();
        this.nextId = 0;
        this.managingFiles.save(bookinglist);
    }
}

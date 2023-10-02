package com.example.biblioteca.DAO.libraryLoanDAO;

import com.example.biblioteca.Model.LibraryLoan;

import java.util.ArrayList;
import java.util.List;

public class LybraryLoanDAOListImplements implements LibraryLoanDAO{
    private ArrayList<LibraryLoan> libraryLoanList;
    private int nextId;

    public LybraryLoanDAOListImplements(){
        this.libraryLoanList = new ArrayList<>();
        this.nextId++;
    }
    @Override
    public LibraryLoan create(LibraryLoan obj) {
        return null;
    }

    @Override
    public void update(LibraryLoan libraryloan) {

    }

    @Override
    public LibraryLoan findById(int id) {
        return null;
    }

    @Override
    public List<LibraryLoan> findMany() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteMany() {

    }
}

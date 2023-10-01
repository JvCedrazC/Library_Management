package com.example.biblioteca.DAO.libraryLoanDAO;

import com.example.biblioteca.DAO.CRUD;
import com.example.biblioteca.Model.LibraryLoan;

import java.util.List;

public interface LibraryLoanDAO extends CRUD<LibraryLoan> {
    public LibraryLoan create(LibraryLoan libraryLoan);
    //Read
    public LibraryLoan findById(int id);

    public List<LibraryLoan> findMany();
    //update
    public void update(LibraryLoan obj);
    //delete
    public void deleteById(int id);
    public void deleteMany();
}

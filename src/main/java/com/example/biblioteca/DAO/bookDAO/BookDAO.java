package com.example.biblioteca.DAO.bookDAO;

import com.example.biblioteca.DAO.CRUD;
import com.example.biblioteca.Model.Book;
import com.example.biblioteca.Model.LibraryLoan;

import java.util.ArrayList;
import java.util.List;

public interface BookDAO extends CRUD<Book> {

    public Book create(Book book);
    public Book findById(int id);
    public ArrayList<Book> findBYISBN(int ISBN);
    public List<Book> findMany();
    public void update(Book obj);
    public void deleteById(int id);
    public void deleteMany();
}

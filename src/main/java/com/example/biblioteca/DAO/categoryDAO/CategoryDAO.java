package com.example.biblioteca.DAO.categoryDAO;

import com.example.biblioteca.DAO.CRUD;
import com.example.biblioteca.Model.Category;
import com.example.biblioteca.Model.LibraryLoan;


import java.util.List;

public interface CategoryDAO extends CRUD<Category> {
    public Category create(Category category);
    public Category findById(int id);
    public List<Category> findMany();
    //update
    public void update(Category obj);
    //delete
    public void deleteById(int id);
    public void deleteMany();

}

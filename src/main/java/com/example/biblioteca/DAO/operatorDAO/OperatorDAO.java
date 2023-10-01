package com.example.biblioteca.DAO.operatorDAO;

import com.example.biblioteca.DAO.CRUD;
import com.example.biblioteca.Model.LibraryLoan;
import com.example.biblioteca.Model.Operator;

import java.util.List;

public interface OperatorDAO extends CRUD<Operator> {
    public Operator create(Operator operator);
    public Operator findById(int id);
    public List<Operator> findMany();
    public void update(Operator obj);
    public void deleteById(int id);
    public void deleteMany();

}

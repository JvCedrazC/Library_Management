package com.example.biblioteca.DAO.operatorDAO;

import com.example.biblioteca.Model.LibraryLoan;
import com.example.biblioteca.Model.Operator;

import java.util.ArrayList;
import java.util.List;

public class OperatorDAOListImplements implements OperatorDAO{
    private int nextId;
    private ArrayList<Operator> operatorList;

    public OperatorDAOListImplements(){
        this.nextId = 0;
        this.operatorList = new ArrayList<>();

    }
    @Override
    public Operator create(Operator operator) {
        operator.setId(nextId);
        this.operatorList.add(operator);
        nextId++;
        return operator;
    }

    @Override
    public Operator findById(int id) {
        return null;
    }
    @Override
    public List<Operator> findMany() {
        return null;
    }

    @Override
    public void update(Operator obj) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteMany() {

    }
}

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
        for (Operator operator: this.operatorList){
            if (operator.getId() == id){
                return operator;
            }
        }
        return null;
    }
    @Override
    public List<Operator> findMany() {
        List<Operator> listoperator = new ArrayList<>();
        for (Object o: this.operatorList){
            listoperator.add((Operator) o);
        }
        return listoperator;
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

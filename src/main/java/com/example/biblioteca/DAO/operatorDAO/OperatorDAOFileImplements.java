package com.example.biblioteca.DAO.operatorDAO;

import com.example.biblioteca.FileUtils.ManagingFiles;
import com.example.biblioteca.Model.Operator;

import java.util.ArrayList;
import java.util.List;

public class OperatorDAOFileImplements implements OperatorDAO{
    private int nextId;
    private ArrayList<Operator> operatorList;
    private ManagingFiles managingFiles;

    public OperatorDAOFileImplements(){
        this.managingFiles = new ManagingFiles("Operator.bin");
        this.operatorList = managingFiles.retrieve();
        if (operatorList.size() != 0){
            this.nextId = operatorList.size();
        }
        else{
            this.nextId = 0;
        }

    }
    @Override
    public Operator create(Operator operator) {
        operator.setId(nextId);
        this.operatorList.add(operator);
        this.managingFiles.save(operatorList);
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
        for (int i = 0; i < operatorList.size(); i++){
            if (this.operatorList.get(i).getId() == obj.getId()){
                this.operatorList.set(i, obj);
            }
        }
        this.managingFiles.save(operatorList);

    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < operatorList.size(); i++){
            if (this.operatorList.get(i).getId() == id){
                this.operatorList.remove(i);
            }
        }
        this.managingFiles.save(operatorList);
    }

    @Override
    public void deleteMany() {
        this.operatorList = new ArrayList<>();
        this.nextId = 0;
        this.managingFiles.save(operatorList);
    }
}

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
       obj.setLibraryLoanId(nextId);
       this.libraryLoanList.add(obj);
       nextId++;
       return obj;
    }

    @Override
    public void update(LibraryLoan libraryloan) {
        for (int i = 0; i < this.libraryLoanList.size(); i++){
            if (this.libraryLoanList.get(i).getLibraryLoanId() == libraryloan.getLibraryLoanId()){
                this.libraryLoanList.set(i, libraryloan);
            }
        }
    }

    @Override
    public LibraryLoan findById(int id) {
        for (LibraryLoan i: this.libraryLoanList){
            if (i.getLibraryLoanId() == id){
                return i;
            }
        }
        return null;
    }

    @Override
    public List<LibraryLoan> findMany() {
        ArrayList<LibraryLoan> listLibraryLoan = new ArrayList<>();
        for (Object o: this.libraryLoanList){
            listLibraryLoan.add((LibraryLoan) o);
        }
        return listLibraryLoan;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < this.libraryLoanList.size();i++){
            if (this.libraryLoanList.get(i).getLibraryLoanId() == id){
                this.libraryLoanList.remove(i);
                break;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.libraryLoanList = new ArrayList<>();
        this.nextId = 0;
    }
}

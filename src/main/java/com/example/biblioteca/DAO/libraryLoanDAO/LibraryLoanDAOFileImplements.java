package com.example.biblioteca.DAO.libraryLoanDAO;

import com.example.biblioteca.FileUtils.ManagingFiles;
import com.example.biblioteca.Model.LibraryLoan;

import java.util.ArrayList;
import java.util.List;

public class LibraryLoanDAOFileImplements implements LibraryLoanDAO {
    private ArrayList<LibraryLoan> libraryLoanList;
    private int nextId;

    private ManagingFiles managingFiles;

    public LibraryLoanDAOFileImplements(){
        this.managingFiles = new ManagingFiles("LibraryLoan.bin");
        this.libraryLoanList = managingFiles.retrieve();
        if (libraryLoanList.size() != 0){
            nextId = libraryLoanList.size();
        }
        else{
            nextId = 0;
        }
    }
    @Override
    public LibraryLoan create(LibraryLoan obj) {
        obj.setLibraryLoanId(nextId);
        this.libraryLoanList.add(obj);
        this.managingFiles.save(libraryLoanList);
        return obj;
    }

    @Override
    public void update(LibraryLoan libraryloan) {
        for (int i = 0; i < this.libraryLoanList.size(); i++){
            if (this.libraryLoanList.get(i).getLibraryLoanId() == libraryloan.getLibraryLoanId()){
                this.libraryLoanList.set(i, libraryloan);
            }
        }
        this.managingFiles.save(libraryLoanList);
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
        this.managingFiles.save(libraryLoanList);
    }

    @Override
    public void deleteMany() {
        this.libraryLoanList = new ArrayList<>();
        this.nextId = 0;
        this.managingFiles.save(libraryLoanList);
    }
}

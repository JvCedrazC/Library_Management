package com.example.biblioteca.DAO.bookDAO;

import com.example.biblioteca.Model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDAOListImplements implements BookDAO{
    private int nextID;
    private ArrayList<Book> bookList;
    public BookDAOListImplements(){
        this.bookList = new ArrayList<Book>();
        nextID = 0;
    }

    @Override
    public Book create(Book book) {
        book.setId(nextID);
        nextID++;
        this.bookList.add(book);
        return book;
    }

    @Override
    public Book findById(int id) {
        for (Book book : this.bookList){
            if (book.getId() == id){
                return book;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Book> findBYISBN(int ISBN) {
        ArrayList<Book> listbook = new ArrayList<Book>();
        for (Book book : this.bookList){
            if (book.getISBN() == ISBN){
                listbook.add(book);
            }
        }
        return listbook;
    }

    @Override
    public List<Book> findMany() {
        List<Book> listbook = new ArrayList<Book>();
        for (Object o: this.bookList){
            listbook.add((Book) o);
        }
        return listbook;
    }

    @Override
    public void update(Book obj) {
        for (int i = 0; i <bookList.size(); i++){
            if (this.bookList.get(i).getId() == obj.getId()){
                this.bookList.set(i, obj);
            }
        }

    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < bookList.size(); i++){
            if (this.bookList.get(i).getId() == id){
                this.bookList.remove(i);
            }
        }

    }

    @Override
    public void deleteMany() {
        this.bookList = new ArrayList<Book>();
        this.nextID = 0;

    }
}

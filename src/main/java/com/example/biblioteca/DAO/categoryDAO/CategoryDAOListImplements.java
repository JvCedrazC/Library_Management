package com.example.biblioteca.DAO.categoryDAO;

import com.example.biblioteca.Model.Category;
import com.example.biblioteca.Model.LibraryLoan;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAOListImplements implements CategoryDAO{
    private ArrayList<Category> CategoryList;
    private int nextId;

    public CategoryDAOListImplements(){
        this.CategoryList = new ArrayList<>();
        this.nextId++;
    }
    @Override
    public Category create(Category obj) {
        obj.setCategoryId(nextId);
        this.CategoryList.add(obj);
        nextId++;
        return obj;
    }

    @Override
    public void update(Category category) {
        for (int i = 0; i < this.CategoryList.size(); i++){
            if (this.CategoryList.get(i).getCategoryId() == category.getCategoryId()){
                this.CategoryList.set(i, category);
            }
        }
    }

    @Override
    public Category findById(int id) {
        for (Category i: this.CategoryList){
            if (i.getCategoryId() == id){
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Category> findMany() {
        ArrayList<Category> listCategory = new ArrayList<>();
        for (Object o: this.CategoryList){
            listCategory.add((Category) o);
        }
        return listCategory;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < this.CategoryList.size();i++){
            if (this.CategoryList.get(i).getCategoryId() == id){
                this.CategoryList.remove(i);
                break;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.CategoryList = new ArrayList<>();
        this.nextId = 0;
    }
}

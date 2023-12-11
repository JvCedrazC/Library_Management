package com.example.biblioteca.DAO.bookDAO;

import com.example.biblioteca.FileUtils.ManagingFiles;
import com.example.biblioteca.Model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDAOFileImplements implements BookDAO{
    private int nextID;
    private ArrayList<Book> bookList;

    private ManagingFiles managingFiles;

    /**
     * Construtor padrão que inicializa a lista de livros e o próximo ID disponível.
     */
    public BookDAOFileImplements(){
        this.managingFiles = new ManagingFiles("Book.bin");
        this.bookList = managingFiles.retrieve();
        if (this.bookList.size() != 0){
            this.nextID = this.bookList.size();
        }
        else {
            nextID = 0;
        }
    }

    /**
     * Cria um novo livro na lista.
     *
     * @param book O livro a ser criado.
     * @return O livro criado com um ID atribuído.
     */
    @Override
    public Book create(Book book) {
        book.setId(nextID);
        nextID++;
        this.bookList.add(book);
        this.managingFiles.save(this.bookList);
        return book;
    }

    /**
     * Encontra um livro pelo seu ID.
     *
     * @param id O ID do livro a ser encontrado.
     * @return O livro encontrado ou null se não for encontrado.
     */
    @Override
    public Book findById(int id) {
        for (Book book : this.bookList){
            if (book.getId() == id){
                return book;
            }
        }
        return null;
    }


    /**
     * Encontra uma lista de livros pelo ISBN.
     *
     * @param ISBN O ISBN dos livros a serem encontrados.
     * @return Uma lista de livros encontrados.
     */
    @Override
    public ArrayList<Book> findBYISBN(int ISBN) {
        ArrayList<Book> listbook = new ArrayList<>();
        for (Book book : this.bookList){
            if (book.getISBN() == ISBN){
                listbook.add(book);
            }
        }
        return listbook;
    }

    /**
     * Retorna uma lista de todos os livros armazenados.
     *
     * @return Uma lista de todos os livros armazenados.
     */
    @Override
    public List<Book> findMany() {
        List<Book> listbook = new ArrayList<>();
        for (Object o: this.bookList){
            listbook.add((Book) o);
        }
        return listbook;
    }


    /**
     * Atualiza um livro na lista.
     *
     * @param obj O livro a ser atualizado.
     */
    @Override
    public void update(Book obj) {
        for (int i = 0; i <bookList.size(); i++){
            if (this.bookList.get(i).getId() == obj.getId()){
                this.bookList.set(i, obj);
            }
        }
        this.managingFiles.save(this.bookList);

    }

    /**
     * Exclui um livro da lista pelo seu ID.
     *
     * @param id O ID do livro a ser excluído.
     */
    @Override
    public void deleteById(int id) {
        for (int i = 0; i < bookList.size(); i++){
            if (this.bookList.get(i).getId() == id){
                this.bookList.remove(i);
                break;
            }
        }
        this.managingFiles.save(this.bookList);

    }


    /**
     * Exclui todos os livros da lista e redefine o próximo ID.
     */
    @Override
    public void deleteMany() {
        this.bookList = new ArrayList<>();
        this.nextID = 0;
        this.managingFiles.save(this.bookList);

    }
}

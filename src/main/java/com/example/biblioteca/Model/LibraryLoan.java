package com.example.biblioteca.Model;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.DAO.bookDAO.BookDAO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
/**
 * Representa um empréstimo de livro de uma biblioteca.
 *
 * @author João Vítor Cedraz
 * @version 1.0
 * @since 2023-08-04
 */

public class LibraryLoan {
    private int libraryLoanId;
    private int customerID;
    private int bookID;
    private int bookISBN;
    private  LocalDate startDate;
    private  LocalDate finishDate;
    private int extendsNumbers = 0;
    private Float tax = 0.0F;
    private BookDAO bookDAO = DAO.getBook();


    /**
     * Cria um novo empréstimo de livro.
     *
     * @param customerID O identificador do cliente que irá pegar o livro emprestado.
     * @param ISBN O ISBN do livro que será emprestado.
     */
    public LibraryLoan(int customerID, int ISBN){
        setCustomerID(customerID);
        setBookISBN(ISBN);
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
    public void setBookISBN(int bookISBN) {
        this.bookISBN = bookISBN;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public void setLibraryLoanId(int libraryLoanId) {
        this.libraryLoanId = libraryLoanId;
    }
    public int getLibraryLoanId() {
        return libraryLoanId;
    }
    public int getBookISBN() { return bookISBN;}
    public int getBookID() {
        return bookID;
    }
    public LocalDate getFinishDate(){
        return this.finishDate;
    }
    public void setFinishDate(LocalDate date){ this.finishDate = date; }
    public LocalDate getStartDate(){ return this.startDate; }
    public void setStartDate(LocalDate date){ this.startDate = date; }


    /**
     * Extende o prazo do empréstimo em 7 dias, até um máximo de 3 extensões.
     */
    public void extend_loan(){
        if (extendsNumbers <= 3){
            this.finishDate = this.finishDate.plusDays(7);
        }
        //Exception
        //Counter
        extendsNumbers += 1;
    }

    /**
     * Calcula a multa pelo atraso na devolução do empréstimo, com base no número de dias de atraso.
     *
     * @param devolutionDate A data da devolução do empréstimo.
     * @return A multa pelo atraso, em reais.
     */
    public Float getTax(LocalDate devolutionDate){
        if (isDelayed(devolutionDate)){
            int days = (int) ChronoUnit.DAYS.between(this.finishDate, devolutionDate);
            return days * 0.25f;
        } else {
            return 0.0f;
        }
    }
    /**
     * Verifica se o empréstimo está atrasado.
     *
     * @param devolutionDate A data da devolução do empréstimo.
     * @return `true` se o empréstimo estiver atrasado, `false` caso contrário.
     */
    public boolean isDelayed(LocalDate devolutionDate){
        if (devolutionDate.isAfter(getFinishDate())){
            return true;
        } else{
            return false;
        }
    }


}

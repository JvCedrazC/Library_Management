package com.example.biblioteca.DAO;

import com.example.biblioteca.DAO.admDAO.AdmDAO;
import com.example.biblioteca.DAO.admDAO.AdmDAOFileImplements;
import com.example.biblioteca.DAO.admDAO.AdmDAOListImplements;
import com.example.biblioteca.DAO.bookDAO.BookDAO;
import com.example.biblioteca.DAO.bookDAO.BookDAOFileImplements;
import com.example.biblioteca.DAO.bookDAO.BookDAOListImplements;
import com.example.biblioteca.DAO.bookingDAO.BookingDAO;
import com.example.biblioteca.DAO.bookingDAO.BookingDAOFileImplements;
import com.example.biblioteca.DAO.bookingDAO.BookingDAOListImplements;
import com.example.biblioteca.DAO.categoryDAO.CategoryDAO;
import com.example.biblioteca.DAO.categoryDAO.CategoryDAOListImplements;
import com.example.biblioteca.DAO.customerDAO.CustomerDAO;
import com.example.biblioteca.DAO.customerDAO.CustomerDAOFileImplements;
import com.example.biblioteca.DAO.customerDAO.CustomerDAOListImplements;
import com.example.biblioteca.DAO.libraryLoanDAO.LibraryLoanDAO;
import com.example.biblioteca.DAO.libraryLoanDAO.LybraryLoanDAOListImplements;
import com.example.biblioteca.DAO.operatorDAO.OperatorDAO;
import com.example.biblioteca.DAO.operatorDAO.OperatorDAOListImplements;

/**
 * A classe DAO fornece métodos estáticos para obter instâncias de diferentes interfaces DAO (Data Access Object)
 * relacionadas a entidades do sistema, como clientes, livros, operadores, empréstimos de biblioteca, administradores e categorias.
 */
public class DAO {
    private static CustomerDAO customerDAO;
    private static BookDAO bookDAO;
    private static OperatorDAO operatorDAO;
    private static LibraryLoanDAO libraryLoanDAO;
    private static AdmDAO admDAO;
    private static CategoryDAO categoryDAO;
    private static BookingDAO bookingDAO;

    /**
     * Obtém uma instância de CustomerDAO, que permite o acesso aos dados dos clientes do sistema.
     *
     * @return Uma instância de CustomerDAO.
     */
    public static CustomerDAO getCustomer(){
        if (customerDAO == null){
            customerDAO = new CustomerDAOFileImplements();
        }
        return customerDAO;
    }

    /**
     * Obtém uma instância de BookDAO, que permite o acesso aos dados dos livros do sistema.
     *
     * @return Uma instância de BookDAO.
     */
    public static BookDAO getBook(){
        if (bookDAO == null){
            bookDAO = new BookDAOFileImplements();
        }
        return bookDAO;
    }


    /**
     * Obtém uma instância de OperatorDAO, que permite o acesso aos dados dos operadores do sistema.
     *
     * @return Uma instância de OperatorDAO.
     */
    public static OperatorDAO getOperatorDAO(){
        if (operatorDAO == null){
            operatorDAO = new OperatorDAOListImplements();
        }
        return operatorDAO;
    }

    /**
     * Obtém uma instância de LibraryLoanDAO, que permite o acesso aos dados dos empréstimos de biblioteca do sistema.
     *
     * @return Uma instância de LibraryLoanDAO.
     */
    public static LibraryLoanDAO getLibraryLoanDAO(){
        if (libraryLoanDAO == null){
            libraryLoanDAO = new LybraryLoanDAOListImplements();
        }
        return libraryLoanDAO;
    }

    /**
     * Obtém uma instância de AdmDAO, que permite o acesso aos dados dos administradores do sistema.
     *
     * @return Uma instância de AdmDAO.
     */
    public static AdmDAO getAdmDAO(){
        if (admDAO == null){
            admDAO = new AdmDAOFileImplements();
        }
        return admDAO;
    }

    /**
     * Obtém uma instância de CategoryDAO, que permite o acesso aos dados das categorias de livros do sistema.
     *
     * @return Uma instância de CategoryDAO.
     */
    public static CategoryDAO getCategoryDAO(){
        if (categoryDAO == null){
            categoryDAO = new CategoryDAOListImplements();
        }
        return categoryDAO;
    }

    public static BookingDAO getBookingDAO(){
        if (bookingDAO == null){
            bookingDAO = new BookingDAOFileImplements();
        }
        return bookingDAO;
    }

}

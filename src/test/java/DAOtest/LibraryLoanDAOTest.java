package DAOtest;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.Model.Book;
import com.example.biblioteca.Model.LibraryLoan;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LibraryLoanDAOTest {
    @AfterEach
    public void tearDown(){
        DAO.getLibraryLoanDAO().deleteMany();
        DAO.getBook().deleteMany();
    }
    @BeforeEach
    public void generateLibraryLoan(){
        LibraryLoan libraryLoan1 = new LibraryLoan(0, 978);
        DAO.getLibraryLoanDAO().create(libraryLoan1);
        LibraryLoan libraryLoan2 = new LibraryLoan(1, 978);
        DAO.getLibraryLoanDAO().create(libraryLoan2);
        LibraryLoan libraryLoan3 = new LibraryLoan(2, 7117);
        DAO.getLibraryLoanDAO().create(libraryLoan3);

    }

    @Test
    public void create(){
        LibraryLoan libraryLoan = new LibraryLoan(0, 978);
        LibraryLoan newLibraryLoan = DAO.getLibraryLoanDAO().create(libraryLoan);
        assertEquals(libraryLoan, newLibraryLoan);
    }
    @Test
    public void findById(){
        LibraryLoan libraryLoan1 = DAO.getLibraryLoanDAO().findById(1);
        assertEquals(libraryLoan1.getBookISBN(), 978);
    }

    @Test
    public void findMany(){
        ArrayList<LibraryLoan> listLibraryLoan = new ArrayList<>();
        listLibraryLoan = (ArrayList<LibraryLoan>) DAO.getLibraryLoanDAO().findMany();
        assertEquals(3, listLibraryLoan.size());
    }

    @Test
    public void update(){
        LibraryLoan newLibraryLoan = DAO.getLibraryLoanDAO().findById(2);
        newLibraryLoan.setBookISBN(978);
        DAO.getLibraryLoanDAO().update(newLibraryLoan);
        assertEquals(978, DAO.getLibraryLoanDAO().findById(2).getBookISBN());
    }

    @Test
    public void deleteById(){
        DAO.getLibraryLoanDAO().deleteById(2);
        assertThrows(IndexOutOfBoundsException.class, () ->DAO.getLibraryLoanDAO().findMany().get(2));
    }

    @Test
    public void deleteMany(){
        DAO.getLibraryLoanDAO().deleteMany();
        assertEquals(0, DAO.getLibraryLoanDAO().findMany().size());
    }
}

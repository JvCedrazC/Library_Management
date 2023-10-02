package DAOtest;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.Model.LibraryLoan;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryLoanDAOTest {
    @AfterEach
    void tearDown(){
        DAO.getOperatorDAO().deleteMany();
    }

    @Test
    public void create(){
        LibraryLoan libraryLoan = new LibraryLoan(0, 978);
        LibraryLoan newLibraryLoan = DAO.getLibraryLoanDAO().create(libraryLoan);
        assertEquals(libraryLoan, newLibraryLoan);
    }
}

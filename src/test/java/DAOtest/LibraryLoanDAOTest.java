package DAOtest;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.Model.Book;
import com.example.biblioteca.Model.LibraryLoan;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryLoanDAOTest {
    @AfterEach
    void tearDown(){
        DAO.getOperatorDAO().deleteMany();
        DAO.getBook().deleteMany();
    }
    @BeforeEach
    void generateLibraryLoan(){
        LibraryLoan libraryLoan1 = new LibraryLoan(0, 978);
        DAO.getLibraryLoanDAO().create(libraryLoan1);
        LibraryLoan libraryLoan2 = new LibraryLoan(1, 978);
        DAO.getLibraryLoanDAO().create(libraryLoan2);
        LibraryLoan libraryLoan3 = new LibraryLoan(2, 7117);
        DAO.getLibraryLoanDAO().create(libraryLoan3);

    }
    @BeforeEach
    void generateBooks(){
        Book book1 = new Book(978, 0, "1808", "Laurentino Gomes", "Planeta Jovem");
        DAO.getBook().create(book1);
        Book book2 = new Book(978, 0, "1808", "Laurentino Gomes", "Planeta Jovem");
        DAO.getBook().create(book2);
        Book book3 = new Book(7117, 1, "Como Treinar seu Dragão", "Cressida Cowell", "Intrinseca");
        DAO.getBook().create(book3);
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
    
}

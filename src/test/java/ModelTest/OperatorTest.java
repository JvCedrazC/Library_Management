package ModelTest;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.Model.Book;
import com.example.biblioteca.Model.Booking;
import com.example.biblioteca.Model.Operator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorTest {
    @BeforeEach
    void generate(){

        //gerando livros
        Book book1 = new Book(978, 0, "1808", "Laurentino Gomes", "Planeta Jovem");
        DAO.getBook().create(book1);
        Book book2 = new Book(978, 0, "1808", "Laurentino Gomes", "Planeta Jovem");
        DAO.getBook().create(book2);
        Book book3 = new Book(7117, 1, "Como Treinar seu Dragão", "Cressida Cowell", "Intrinseca");
        DAO.getBook().create(book3);

        //gerando um operador
        Operator operator1 = new Operator(-1, "Silvano Sales");
        DAO.getOperatorDAO().create(operator1);
    }

    @AfterEach
    void teardown(){
        DAO.getBook().deleteMany();
        DAO.getOperatorDAO().deleteMany();
        DAO.getLibraryLoanDAO().deleteMany();
    }
    @Test
    void makeLoan(){
        Operator operator = new Operator(0, "Ronaldo Nazário");
        operator.make_loan(978, 0);
        assertEquals(1, DAO.getLibraryLoanDAO().findMany().size());
    }

    @Test
    void newCustomer(){
        Operator operator = DAO.getOperatorDAO().findById(0);
        operator.newCustomer("Erling Haaland");
        assertEquals("Erling Haaland", DAO.getCustomer().findById(0).getNome());

    }

    @Test
    public void booking(){
        Booking newbooking = new Booking(0, 978);
        Operator operator = DAO.getOperatorDAO().findById(0);
        operator.startBooking("2023-10-02", 3, newbooking);
        LocalDate date = LocalDate.parse("2023-10-05", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        assertEquals(newbooking.getFinishdate(), date);

    }

    @Test
    public void newBook(){
        Operator op = new Operator(-1, "Robert DeNiro");
        op.newBook(978, "1808", "Planeta Jovem", "Laurentino Gomes", 0 );
        assertEquals("1808", DAO.getBook().findById(3).getName());
    }
}

package DAOtest;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.Model.Book;
import com.example.biblioteca.Model.Booking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingDAOTest {
    @AfterEach
    void tearDown(){
        DAO.getBookingDAO().deleteMany();
        DAO.getBook().deleteMany();
    }

    @BeforeEach
    void generate(){
        Book book1 = new Book(978, 0, "1808", "Laurentino Gomes", "Planeta Jovem");
        DAO.getBook().create(book1);
        Book book2 = new Book(978, 0, "1808", "Laurentino Gomes", "Planeta Jovem");
        DAO.getBook().create(book2);
        Book book3 = new Book(7117, 1, "Como Treinar seu Dragão", "Cressida Cowell", "Intrinseca");
        DAO.getBook().create(book3);
    }

    @Test
    public void create(){
        Booking booking = new Booking(0, 978);
        Booking newBooking = DAO.getBookingDAO().create(booking);
        assertEquals(booking, newBooking);
    }




}

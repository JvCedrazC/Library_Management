package DAOtest;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.Model.Book;
import com.example.biblioteca.Model.Booking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingDAOTest {
    @AfterEach
    void tearDown(){
        DAO.getBookingDAO().deleteMany();
        DAO.getBook().deleteMany();
    }

    @BeforeEach
    void generate(){

        //Books
        Book book1 = new Book(978, 0, "1808", "Laurentino Gomes", "Planeta Jovem");
        DAO.getBook().create(book1);
        Book book2 = new Book(978, 0, "1808", "Laurentino Gomes", "Planeta Jovem");
        DAO.getBook().create(book2);
        Book book3 = new Book(7117, 1, "Como Treinar seu Dragão", "Cressida Cowell", "Intrinseca");
        DAO.getBook().create(book3);

        //Booking
        Booking booking1 = new Booking(0, 978);
        DAO.getBookingDAO().create(booking1);
        Booking booking2 = new Booking(0, 978);
        DAO.getBookingDAO().create(booking2);
        Booking booking3 = new Booking(0, 7117);
        DAO.getBookingDAO().create(booking3);

    }

    @Test
    public void create(){
        Booking booking = new Booking(0, 978);
        Booking newBooking = DAO.getBookingDAO().create(booking);
        assertEquals(booking, newBooking);
    }

    @Test
    void findById(){
        Booking booking = DAO.getBookingDAO().findById(2);
        int i = booking.getISBN();
        int j = DAO.getBook().findBYISBN(i).get(0).getISBN();
        assertEquals(j, i);
    }

    @Test
    void findMany(){
        ArrayList<Booking> listBooking = (ArrayList<Booking>) DAO.getBookingDAO().findMany();
        assertEquals(3, listBooking.size());
    }

    @Test
    void update(){
        Booking newBooking = DAO.getBookingDAO().findById(0);
        LocalDate localDate = LocalDate.parse("2023-10-02", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        newBooking.setStartdate(localDate);
        DAO.getBookingDAO().update(newBooking);
        assertEquals(localDate, DAO.getBookingDAO().findById(0).getStartdate());
    }




}

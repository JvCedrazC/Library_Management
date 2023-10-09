package DAOtest;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.Model.Booking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingDAOTest {

    @Test
    public void create(){
        Booking booking = new Booking(0, 978);
        Booking newBooking = DAO.getBookingDAO().create(booking);
        assertEquals(booking, newBooking);
    }

}

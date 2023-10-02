package ModelTest;

import com.example.biblioteca.Model.Booking;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingTest {
    @Test
    public void booking(){
        Booking newbooking = new Booking();
        newbooking.startBooking("2023-10-02", 3);
        LocalDate date = LocalDate.parse("2023-10-05", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        assertEquals(newbooking.getFinishdate(), date);

    }
}

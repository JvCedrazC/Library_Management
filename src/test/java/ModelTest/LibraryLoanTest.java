package ModelTest;

import com.example.biblioteca.Model.LibraryLoan;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryLoanTest {

    @Test
    void isDelayed(){
        LocalDate sDate = LocalDate.parse("2023-10-02", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fDate = sDate.plusDays(7);
        LocalDate dDate = LocalDate.parse("2023-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LibraryLoan libraryLoan = new LibraryLoan(0, 978);
        libraryLoan.setStartDate(sDate);
        libraryLoan.setFinishDate(fDate);
        assertTrue(libraryLoan.isDelayed(dDate));
    }
    @Test
    void getTax (){
        LocalDate sDate = LocalDate.parse("2023-10-02", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fDate = sDate.plusDays(7);
        LocalDate dDate = LocalDate.parse("2023-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LibraryLoan libraryLoan = new LibraryLoan(0, 978);
        libraryLoan.setStartDate(sDate);
        libraryLoan.setFinishDate(fDate);
        assertEquals(0.25f, libraryLoan.getTax(dDate));
    }

    @Test
    void extend_loan(){
        LocalDate sDate = LocalDate.parse("2023-10-02", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fDate = sDate.plusDays(7);
        LocalDate nDate = LocalDate.parse("2023-10-16", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LibraryLoan libraryLoan = new LibraryLoan(0, 978);
        libraryLoan.setStartDate(sDate);
        libraryLoan.setFinishDate(fDate);
        libraryLoan.extend_loan();
        assertEquals(nDate, libraryLoan.getFinishDate());
    }
}

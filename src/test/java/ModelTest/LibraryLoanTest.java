package ModelTest;

import com.example.biblioteca.Model.LibraryLoan;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe de teste para testar os métodos da classe LibraryLoan.
 */
public class LibraryLoanTest {
    /**
     * Testa o método isDelayed() da classe LibraryLoan.
     *
     * Este teste verifica se o método isDelayed() retorna verdadeiro quando o empréstimo está atrasado e falso quando não está.
     *
     * @throws java.time.format.DateTimeParseException Se ocorrer um erro na formatação das datas.
     */
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

    /**
     * Testa o método getTax() da classe LibraryLoan.
     *
     * Este teste verifica se o método getTax() calcula corretamente a taxa de multa com base na data de devolução.
     *
     * @throws java.time.format.DateTimeParseException Se ocorrer um erro na formatação das datas.
     */
    @Test
    void getTax (){
        // Define a data de início, data de fim e data de devolução esperada.
        LocalDate sDate = LocalDate.parse("2023-10-02", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fDate = sDate.plusDays(7);
        LocalDate dDate = LocalDate.parse("2023-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));


        // Cria uma instância de LibraryLoan e configura as datas.
        LibraryLoan libraryLoan = new LibraryLoan(0, 978);
        libraryLoan.setStartDate(sDate);
        libraryLoan.setFinishDate(fDate);

        // Calcula a taxa de multa com base na data de devolução e a compara com o valor esperado.
        assertEquals(0.25f, libraryLoan.getTax(dDate));
    }

    /**
     * Testa o método extend_loan() da classe LibraryLoan.
     *
     * Este teste verifica se o método extend_loan() estende corretamente a data de devolução esperada.
     *
     * @throws java.time.format.DateTimeParseException Se ocorrer um erro na formatação das datas.
     */
    @Test
    void extend_loan(){
        // Define a data de início, data de fim e nova data de devolução esperada.
        LocalDate sDate = LocalDate.parse("2023-10-02", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fDate = sDate.plusDays(7);
        LocalDate nDate = LocalDate.parse("2023-10-16", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Cria uma instância de LibraryLoan e configura as datas.
        LibraryLoan libraryLoan = new LibraryLoan(0, 978);
        libraryLoan.setStartDate(sDate);
        libraryLoan.setFinishDate(fDate);

        // Realiza a extensão do empréstimo e verifica se a nova data de devolução está correta.
        libraryLoan.extend_loan();
        assertEquals(nDate, libraryLoan.getFinishDate());
    }
}

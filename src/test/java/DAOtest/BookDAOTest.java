package DAOtest;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.Model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookDAOTest {
    @AfterEach
    void tearDown(){
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
        Book book1 = new Book(978, 0, "1808", "Laurentino Gomes", "Planeta Jovem");
        Book nBook1 = DAO.getBook().create(book1);
        assertEquals(book1.getId(), nBook1.getId());
    }
    @Test
    public void findById(){
        Book book = DAO.getBook().findById(1);
        assertEquals("1808", book.getName());
    }
    @Test
    public void findByISBN(){
        ArrayList<Book> booklist = new ArrayList<>();
        booklist = DAO.getBook().findBYISBN(978);
        assertEquals(2, booklist.size());
    }

    @Test
    public void findMany(){
        ArrayList<Book> booklist = new ArrayList<>();
        booklist = (ArrayList<Book>) DAO.getBook().findMany();
        assertEquals(3, DAO.getBook().findMany().size());
    }

    @Test
    public void update(){
        Book nBook = DAO.getBook().findById(0);
        nBook.setLocked(1);
        DAO.getBook().update(nBook);
        assertEquals(1, DAO.getBook().findById(0).getLocked());
    }

    @Test
    public void deleteById(){
        DAO.getBook().deleteById(2);
        assertThrows(IndexOutOfBoundsException.class, () ->DAO.getBook().findMany().get(2));
    }
    @Test
    public void deleteMany(){
        DAO.getBook().deleteMany();
        assertEquals(0,DAO.getBook().findMany().size());
    }

}

package DAOtest;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.Model.Book;
import com.example.biblioteca.Model.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryDAOTest {

    @BeforeEach
    void generate(){
        Book book1 = new Book(978, 0, "1808", "Laurentino Gomes", "Planeta Jovem");
        DAO.getBook().create(book1);
        Book book2 = new Book(978, 0, "1808", "Laurentino Gomes", "Planeta Jovem");
        DAO.getBook().create(book2);
        Book book3 = new Book(7117, 1, "Como Treinar seu Dragão", "Cressida Cowell", "Intrinseca");
        DAO.getBook().create(book3);
        Category category1 = new Category("História", -1);
        Category category2 = new Category("Ficção", -1);
        DAO.getCategoryDAO().create(category1);
        DAO.getCategoryDAO().create(category2);
    }

    @AfterEach
    void tearDown(){
        DAO.getBook().deleteMany();
        DAO.getCategoryDAO().deleteMany();
    }

    @Test
    void create(){
        Category category1 = new Category("História", -1);
        Category category2 = DAO.getCategoryDAO().create(category1);
        assertEquals(category2, category1);
    }

    @Test
    void findById(){
        Category category = DAO.getCategoryDAO().findById(0);
        assertEquals("História", category.getName());
    }

}

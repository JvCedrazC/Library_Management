package ModelTest;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.Model.Book;
import com.example.biblioteca.Model.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {
    @Test
    public void addBook(){
        Book book1 = new Book(978, 0, "1808", "Laurentino Gomes", "Planeta Jovem");
        Category category = new Category("History", 978);
        Category ncategory = DAO.getCategoryDAO().create(category);
        assertEquals(1, ncategory.getISBNlist().size());
    }
}

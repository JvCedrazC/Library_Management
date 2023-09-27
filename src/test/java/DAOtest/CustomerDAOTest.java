package DAOtest;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.DAO.customerDAO.CustomerDAO;
import com.example.biblioteca.Model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerDAOTest {
    @BeforeEach
    void teardown(){
        DAO.getCustomer().deleteMany();
    }
    @Test
    void create(){
        CustomerDAO customerDAO = DAO.getCustomer();
        Customer customer1 = new Customer(0, "LeBron James");
        Customer novo1 = DAO.customerDAO.create(customer1);
        assertEquals(novo1, customer1);
    }
}

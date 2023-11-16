package DAOtest;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.DAO.customerDAO.CustomerDAO;
import com.example.biblioteca.Model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerDAOTest {
    CustomerDAO customerDAO = DAO.getCustomer();
    @AfterEach
    public void teardown(){
        DAO.getCustomer().deleteMany();
    }
    @BeforeEach
    public void generate(){
        Customer customer1 = new Customer(-1, "LeBron James");
        customerDAO.create(customer1);
        Customer customer2 = new Customer(-1, "Lionel Messi");
        customerDAO.create(customer2);
        Customer customer3 = new Customer(-1, "Cristiano Ronaldo");
        customerDAO.create(customer3);
    }

    @Test
    public void create(){
        Customer customer1 = new Customer(0, "LeBron James");
        Customer novo1 = DAO.getCustomer().create(customer1);
        assertEquals(novo1, customer1);
    }

    @Test
    public void findByID(){
        Customer customer = customerDAO.findById(1);
        assertEquals("Lionel Messi", customer.getNome());
    }

    @Test
    public void findMany(){
        ArrayList<Customer> customersList = new ArrayList<>();
        customersList = (ArrayList<Customer>) DAO.getCustomer().findMany();
        assertEquals(3, customersList.size());
    }

    @Test
    public void update(){
        Customer newCustomer = customerDAO.findById(2);
        newCustomer.setNome("Robert Lewandowski");
        customerDAO.update(newCustomer);
        assertEquals("Robert Lewandowski", customerDAO.findById(2).getNome());
    }
    @Test
    public void deleteById(){
        customerDAO.deleteById(2);
        assertEquals(2, customerDAO.findMany().size());
    }

    @Test
    public void deleteMany(){
        customerDAO.deleteMany();
        assertEquals(0, customerDAO.findMany().size());
    }
}

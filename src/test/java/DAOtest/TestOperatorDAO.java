package DAOtest;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.Model.Operator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestOperatorDAO {

    @AfterEach
    void tearDown(){
        DAO.operatorDAO.deleteMany();
    }

    @BeforeEach
    void generate(){
        Operator operator1 = new Operator(-1, "Silvano Sales");
        DAO.getOperatorDAO().create(operator1);
        Operator operator2 = new Operator(-1, "Michael Jackson");
        DAO.getOperatorDAO().create(operator2);
        Operator operator3 = new Operator(-1, "Seu Jorge");
        DAO.getOperatorDAO().create(operator3);
    }
    @Test
    public void create(){
        Operator operator = new Operator(-1, "Michael Jackson");
        Operator newOperator = DAO.getOperatorDAO().create(operator);
        assertEquals(operator, newOperator);
    }

    @Test
    public void findById(){
        assertEquals("Seu Jorge", DAO.getOperatorDAO().findById(2).getNome());
    }

    @Test
    public void findMany(){
        ArrayList<Operator> listoperator = (ArrayList<Operator>) DAO.getOperatorDAO().findMany();
        assertEquals(3, listoperator.size());
    }

    @Test
    public void update(){
        Operator  operator = DAO.getOperatorDAO().findById(2);
        operator.setNome("Mr Jorge");
        DAO.getOperatorDAO().update(operator);
        assertEquals("Mr Jorge", DAO.getOperatorDAO().findById(2).getNome());
    }

    
}

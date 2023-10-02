package DAOtest;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.Model.Operator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestOperatorDAO {

    @Test
    public void create(){
        Operator operator = new Operator(-1, "Michael Jackson");
        Operator newOperator = DAO.getOperatorDAO().create(operator);
        assertEquals(operator, newOperator);
    }

    
}

import DAOtest.*;
import com.example.biblioteca.DAO.operatorDAO.OperatorDAO;
import org.junit.runner.*;
import org.junit.runners.*;
@RunWith(Suite.class)
@Suite.SuiteClasses( {
        AdmDAOTest.class,
        BookingDAOTest.class,
        BookDAOTest.class,
        //CategoryDAOTest.class,
        CustomerDAOTest.class,
        LibraryLoanDAOTest.class,
        TestOperatorDAO.class

})
public class suiteTest {}
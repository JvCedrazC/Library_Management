package DAOtest;

import com.example.biblioteca.DAO.DAO;
import com.example.biblioteca.Model.Adm;
import com.example.biblioteca.Model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdmDAOTest {
    @AfterEach
    void tearDown(){
        DAO.getAdmDAO().deleteMany();
    }

    @BeforeEach
    void generate(){
        Adm adm1 = new Adm(-1, "Michael Phelps");
        Adm novo1 = DAO.getAdmDAO().create(adm1);
        Adm adm2 = new Adm(-1, "Usain Bolt");
        Adm novo2 = DAO.getAdmDAO().create(adm2);
        Adm adm3 = new Adm(-1, "Arthur Zanetti");
        Adm novo3 = DAO.getAdmDAO().create(adm3);
    }
    @Test
    public void create(){
        Adm adm1 = new Adm(-1, "LeBron James");
        Adm novo1 = DAO.getAdmDAO().create(adm1);
        assertEquals(novo1, novo1);
    }

    @Test
    public void findById(){
        Adm adm = DAO.getAdmDAO().findById(1);
        assertEquals("Usain Bolt", adm.getNome());
    }

    @Test
    public void findMany(){
        ArrayList<Adm> admList = new ArrayList<>();
        admList = (ArrayList<Adm>) DAO.getAdmDAO().findMany();
        assertEquals(3, admList.size());
    }

    @Test
    public void update(){
        Adm newAdm = DAO.getAdmDAO().findById(2);
        newAdm.setNome("Simone Biles");
        DAO.getAdmDAO().update(newAdm);
        assertEquals("Simone Biles", DAO.getAdmDAO().findById(2).getNome());
    }
    @Test
    public void deleteById(){
        DAO.getAdmDAO().deleteById(2);
        assertThrows(IndexOutOfBoundsException.class, () ->DAO.getAdmDAO().findMany().get(2));
    }

    @Test
    public void deleteMany(){
        DAO.getAdmDAO().deleteMany();
        assertEquals(0, DAO.getAdmDAO().findMany().size());
    }
}

package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.Deparment;
import edu.upc.eetac.dsa.model.Employee;
import edu.upc.eetac.dsa.util.ObjectHelper;
import edu.upc.eetac.dsa.util.QueryHelper;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class QueryHelperTest {

    @Test
    public void ProbarSetter(){
        Employee e = new Employee("Jordi", "Llaveria",500);
        ObjectHelper.setter(e,"name","Juan");
        Assert.assertEquals(e.getName(),"Juan");
    }
    @Test
    public void ProbarGetter(){
        Employee e = new Employee("Jordi", "Llaveria",500);
        String name = (String) ObjectHelper.getter(e,"name");
        Assert.assertEquals(e.getName(),name);
    }
    @Test
    public void testInsert(){
        Employee e = new Employee("Jordi", "Llaveria",500);
        SessionImpl sess = null;
        sess.save(e);
    }
    @Test
    public void testQueryUPDATE(){
        Assert.assertEquals("UPDATE Employee SET name = ?, surname = ?, salary = ? WHERE ID = ?",
                QueryHelper.createQueryUPDATE(new Employee("Juan", "lopez", 333333)));
    }
    @Test
    public void testQueryINSERT() {
        Assert.assertEquals("INSERT INTO Employee (ID, name, surname, salary) VALUES (?, ?, ?, ?)",
                QueryHelper.createQueryINSERT(new Employee("Juan", "lopez", 333333)));
    }

    @Test
    public void testQueryINSERT2() {
        Assert.assertEquals("INSERT INTO Deparment (ID, name, description) VALUES (?, ?, ?)",
                QueryHelper.createQueryINSERT(new Deparment("ENTEL", "ENGINYERIA TELEMÀTICA")));
    }

    @Test
    public void testQuerySELECT() {
        Assert.assertEquals("SELECT * FROM Employee WHERE ID = ?",
                QueryHelper.createQuerySELECT(new Employee("Juan", "lopez", 333333)));
    }

    @Test
    public void testQuerySELECT2() {
        Assert.assertEquals("SELECT * FROM Deparment WHERE ID = ?",
                QueryHelper.createQuerySELECT(new Deparment("ENTEL", "ENGINYERIA TELEMÀTICA")));
    }

}

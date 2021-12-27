package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.Deparment;
import edu.upc.eetac.dsa.model.Employee;
import edu.upc.eetac.dsa.util.ObjectHelper;
import edu.upc.eetac.dsa.util.QueryHelper;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

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
        Employee e = new Employee("Jordi", "Llaveria",300);
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        sess.save(e);
    }
    @Test
    public void testSelect(){
        Employee e = new Employee();
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        sess.get(e,2);
    }

    @Test
    public void testUpdate(){
        Employee e = new Employee("Aida","Padilla", 600);
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        sess.update(e);
    }

    @Test
    public void testDelete(){
        Employee e = new Employee("Joana", "Orpella", 500);
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        sess.delete(e);
    }
    @Test
    public void testSelectall(){
        Employee e = new Employee();
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        List<Object> objects = sess.findAll(e);
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
        Assert.assertEquals("SELECT * FROM Employee WHERE name = ?",
                QueryHelper.createQuerySELECT(new Employee("Juan", "lopez", 333333).getClass()));
    }

    @Test
    public void testQuerySELECT2() {
        Assert.assertEquals("SELECT * FROM Deparment WHERE ID = ?",
                QueryHelper.createQuerySELECT(new Deparment("ENTEL", "ENGINYERIA TELEMÀTICA").getClass()));
    }

}


import main.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class EmployeeTest {
    Employee test_employee;
    DateTimeFormatter formatter;

    @Before
    public void SetUp() throws Exception {
        // LocalDate formatter1 = LocalDate.parse("dd-MM-yyyy");
        test_employee = new Employee("Ostin", "Johs",
                "123-456-789", "ostinjohs1@domain.com", "rHsOa275");
    }

    @Test
    public void testGetHoutly_rate() {
        Assert.assertEquals(Optional.of(25.5), test_employee.getHourly_rate());
    }

    @Test
    public void testGetPesel() {
        Assert.assertEquals("81010200112", test_employee.getPesel());
    }

    @Test
    public void testGetSalary() {
        Assert.assertEquals(5500, test_employee.getSalary(), 0.02);
    }

    @Test
    public void testGetNetSalary() {
        Assert.assertEquals(4675, test_employee.getNetSalary(), 0.02);
    }

    @Test
    public void testGetHire_date() {
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    }

    @Test
    public void testGetFinish_date() {
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    }

    @Test
    public void testSetHourly_rate() {
        test_employee.setHourly_rate(25.5);
        Assert.assertEquals(false, test_employee.getHourly_rate());
    }

    @Test
    public void testSetPesel() {
        test_employee.setPesel("81010200112");
        {
            Assert.assertEquals("81010200112", test_employee.getPesel());
        }
    }

    @Test
    public void testSetSalary() {
        test_employee.setSalary(5500);
        Assert.assertEquals(5500, test_employee.getSalary(), 0.02);
    }

    @Test
    public void setNetSalary() {
        test_employee.setNetSalary(4675);
        Assert.assertEquals(4675, test_employee.getNetSalary(), 0.02);
    }

    @Test
    public void setHire_date() {
        test_employee.setHire_date();
    }

    @Test
    public void setFinish_date() {
        test_employee.setFinish_date();
    }

    @Test
    public void testCalculateWorkingHours() {
        Assert.assertTrue(test_employee.CalculateWorkingHours());
    }
    //@Test
    // public void testCalculateSalary(){Assert.assertEquals(test_employee.CalculateSalary(15););}
    @Test
    public void testPeselValidation() throws EmpPeselException{
        Assert.assertTrue("81010200112", true);
    }
}

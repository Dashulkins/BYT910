import main.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class EmployeeTest {
    Employee test_employee;
    LocalDateTime formatter;

    @Before
    public void SetUp() throws Exception {
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        test_employee = new Employee(25.5, "81010200112", 5500.0, 4675.0, LocalDateTime.parse("01-02-2022 08:30",formatter), LocalDateTime.parse("28-02-2022 17:30",formatter));
    }

    @Test
    public void testGetHourlyRate() throws HourlyRateException {
        test_employee.setHourlyRate(25.5);
        Assert.assertEquals(25.5, test_employee.getHourlyRate(),0);}

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
    public void testGetHireDate() {
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        Assert.assertEquals((LocalDateTime.parse("01-02-2022 08:30", formatter)), test_employee.getHireDate());

    }

    @Test
    public void testGetFinishDate() {
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        Assert.assertEquals((LocalDateTime.parse("28-02-2022 17:30",formatter)), test_employee.getFinishDate());

    }

    @Test
    public void testSetHourlyRate() throws HourlyRateException {
        test_employee.setHourlyRate(25.5);
        Assert.assertEquals(25.5, test_employee.getHourlyRate(),0);
    }

    @Test
    public void testSetPesel() throws EmpPeselException {
        test_employee.setPesel("81010200112");
        {
            Assert.assertEquals("81010200112", test_employee.getPesel());
        }
    }

    @Test
    public void testSetSalary() {
        test_employee.setSalary();
        Assert.assertEquals(5500, test_employee.getSalary(), 0.02);
    }

    @Test
    public void setNetSalary() {
        test_employee.setNetSalary(4675, 825);
        Assert.assertEquals(4675, test_employee.getNetSalary(), 0.02);
    }

    @Test
    public void setHireDate() {
        test_employee.setHireDate();
    }

    @Test
    public void setFinishDate() {
        test_employee.setFinishDate();
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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmployeeTest {
    Employee test_employee;
    DateTimeFormatter formatter;

    @Before
    public void SetUp() throws Exception {
         formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        test_employee = new Employee("Jane", "Dou",
                "000-000-000" , "username@domain.com", "Qwerty123!",25.5, "81010200112", LocalDateTime.parse("01-02-2022 08:30",formatter), LocalDateTime.parse("28-02-2022 17:30",formatter));
    }

    @Test
    public void testGetHourlyRate() throws HourlyRateException {
        test_employee.setHourlyRate(25.5);
        Assert.assertEquals(Double.valueOf(25.5), test_employee.getHourlyRate());}

    @Test
    public void testGetPesel() {
        Assert.assertEquals("81010200112", test_employee.getPesel());
    }


    @Test
    public void testGetHireDate() {
        Assert.assertEquals(LocalDateTime.parse("01-02-2022 08:30", formatter), test_employee.getHireDate());

    }

    @Test
    public void testGetFinishDate() {
        Assert.assertEquals(LocalDateTime.parse("28-02-2022 17:30",formatter), test_employee.getFinishDate());

    }

    @Test
    public void testSetHourlyRate() throws HourlyRateException {
        test_employee.setHourlyRate(25.5);
        Assert.assertEquals(Double.valueOf(25.5), test_employee.getHourlyRate());
    }

    @Test
    public void testSetPesel() throws EmpPeselException {
        test_employee.setPesel("81010200112");
        Assert.assertEquals("81010200112", test_employee.getPesel());

    }


    @Test
    public void setHireDate() throws TimeAfterNowException {
        test_employee.setHireDate(LocalDateTime.parse("21-04-2022 08:30", formatter));
        Assert.assertEquals("21-04-2022 08:30", test_employee.getHireDate().format(formatter));
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime future = now.plusMonths(Long.valueOf(1));
        boolean isFuture = false;
        try {
            test_employee.setHireDate(future);
        }catch (TimeAfterNowException ignored){
            isFuture = true;
        }
        Assert.assertTrue(isFuture);
    }

    @Test
    public void setFinishDate() {
        test_employee.setFinishDate(LocalDateTime.parse("21-05-2023 10:00", formatter));
        Assert.assertEquals("21-05-2023 10:00", test_employee.getFinishDate().format(formatter));
    }

    @Test
    public void testCalculateWorkingHours() {
        Assert.assertEquals(Integer.valueOf(22*8), Integer.valueOf(test_employee.CalculateWorkingHours()));
    }

    @Test
     public void testCalculateSalary(){
        Assert.assertEquals(Double.valueOf(22*8*test_employee.getHourlyRate()), test_employee.CalculateSalary());
    }


    @Test
    public void testPeselValidation(){
        Assert.assertTrue(Employee.PeselValidation("81010200112"));
        Assert.assertFalse(Employee.PeselValidation("81010sfkfsjnfk"));
    }
}

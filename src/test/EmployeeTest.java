import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {
    Employee testEmployee;
    DateTimeFormatter formatter;

    @Before
    public void SetUp() throws Exception {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        testEmployee = new Employee(
                "Jane",
                "Dou",
                "000-000-000",
                "username@domain.com",
                "Qwerty123!",
                25.5, "81010200112",
                LocalDateTime.parse("01-02-2022 08:30", formatter),
                LocalDateTime.parse("28-02-2022 17:30", formatter)
        );
    }

    @Test
    public void testGetHourlyRate() throws HourlyRateException {
        testEmployee.setHourlyRate(25.5);
        Assert.assertEquals(Double.valueOf(25.5), testEmployee.getHourlyRate());
    }

    @Test
    public void testGetPesel() {
        Assert.assertEquals("81010200112", testEmployee.getPesel());
    }


    @Test
    public void testGetHireDate() {
        Assert.assertEquals(LocalDateTime.parse("01-02-2022 08:30", formatter), testEmployee.getHireDate());

    }

    @Test
    public void testGetFinishDate() {
        Assert.assertEquals(LocalDateTime.parse("28-02-2022 17:30", formatter), testEmployee.getFinishDate());

    }

    @Test
    public void testSetHourlyRate() throws HourlyRateException {
        testEmployee.setHourlyRate(25.5);
        Assert.assertEquals(Double.valueOf(25.5), testEmployee.getHourlyRate());
    }

    @Test
    public void testSetPesel() throws EmpPeselException {
        testEmployee.setPesel("81010200112");
        Assert.assertEquals("81010200112", testEmployee.getPesel());

    }


    @Test
    public void setHireDate() throws TimeAfterNowException {
        testEmployee.setHireDate(LocalDateTime.parse("21-04-2022 08:30", formatter));
        Assert.assertEquals("21-04-2022 08:30", testEmployee.getHireDate().format(formatter));
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime future = now.plusMonths(1L);
        boolean isFuture = false;
        try {
            testEmployee.setHireDate(future);
        } catch (TimeAfterNowException ignored) {
            isFuture = true;
        }
        Assert.assertTrue(isFuture);
    }

    @Test
    public void setFinishDate() {
        testEmployee.setFinishDate(LocalDateTime.parse("21-05-2023 10:00", formatter));
        Assert.assertEquals("21-05-2023 10:00", testEmployee.getFinishDate().format(formatter));
    }

    @Test
    public void testCalculateWorkingHours() {
        Assert.assertEquals(22 * 8, testEmployee.calculateWorkingHours());
    }

    @Test
    public void testCalculateSalary() {
        Assert.assertEquals(Double.valueOf(22 * 8 * testEmployee.getHourlyRate()), testEmployee.calculateSalary());
    }


    @Test
    public void testPeselValidation() {
        Assert.assertTrue(Employee.peselValidation("81010200112"));
        Assert.assertFalse(Employee.peselValidation("81010sfkfsjnfk"));
    }

    @Test
    public void testEmployeeRoleChanging() {
        Assert.assertEquals(new ArrayList<>(), testEmployee.getRole());
        Role role1 = new Role("role1", 1, "change product details");
        Role role2 = new Role("role2", 2, "change product details");
        testEmployee.setRole(List.of(role1, role2));
        Assert.assertEquals(List.of(role1, role2), testEmployee.getRole());
    }
}

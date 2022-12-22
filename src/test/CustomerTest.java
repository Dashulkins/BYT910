import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CustomerTest {

    Customer test_customer;

    @Before
    public void SetUp() throws Exception {
        test_customer = new Customer("Jane", "Dou",
                "000-000-000" , "username@domain.com", "Qwerty123!");

    }


    //validations of data
    @Test
    public void testValidatePassword() {
        ArrayList<String> invalidPasswords = new ArrayList<>();
        ArrayList<String> validPasswords = new ArrayList<>();

        invalidPasswords.add("12345678");  //only digits
        invalidPasswords.add("abcdefgh"); //only lowercase
        invalidPasswords.add("ABCDEFGH"); //only uppercase
        invalidPasswords.add("123"); //only 3 symb (min is 8)
        invalidPasswords.add("1ABCDEFGH"); //at least one lowercase and special symbol

        invalidPasswords.forEach(i -> Assert.assertFalse(test_customer.isValidPassword(i)));


        validPasswords.add("ABcdef123!");
        validPasswords.add("@abcDefg456");
        validPasswords.add("!A3456cdefg");

        validPasswords.forEach(v -> Assert.assertTrue(test_customer.isValidPassword(v)));
    }



    @Test
    public void testValidateEmail() {
        String valid = "jane12345@gmail.com";
        String invalid = "hgdte   fe@mf.com";

        Assert.assertTrue(test_customer.isValidEmail(valid));
        Assert.assertFalse(test_customer.isValidEmail(invalid));
    }


    @Test
    public void testValidatePhone() {
        ArrayList<String> valid = new ArrayList<>();
        valid.add("000-000-000");
        valid.add("000 000 000");
        valid.add("000.000.000");

        valid.forEach(v -> Assert.assertTrue(test_customer.isValidPhone(v)));
    }

    @Test
    public void testValidateFirstNames() { //Last Name have same validator
        ArrayList<String> valid = new ArrayList<>();
        ArrayList<String> invalid = new ArrayList<>();

        valid.add("Jane");
        valid.add("Dou");

        invalid.add("12345");
        invalid.add("dou");
        invalid.add("J4ne");

        valid.forEach(v -> Assert.assertTrue(test_customer.isValidFirstName(v)));

        invalid.forEach(i -> Assert.assertFalse(test_customer.isValidFirstName(i)));
    }


    //getters test
    @Test
    public void testGetFName() {
        Assert.assertEquals("Jane", test_customer.getFirstName());
    }

    @Test
    public void testGetLName() {
        Assert.assertEquals("Dou", test_customer.getLastName());
    }

    @Test
    public void testGetEmail() {
        Assert.assertEquals("username@domain.com", test_customer.getEmail());
    }

    @Test
    public void testGetPhone() {
        Assert.assertEquals("000-000-000", test_customer.getPhone());
    }

    @Test
    public void testGetPassword() {
        Assert.assertEquals("Qwerty123!", test_customer.getPassword());
    }

    @Test
    public void testGetDiscount() {
        Assert.assertEquals(0.0, test_customer.getDiscount(), 0);
    }

    @Test
    public void testGetOrders() {
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order(1L, LocalDateTime.parse("23-12-2021 12:33",formatter), "Warsaw, Koszykowa 86",true));
        test_customer.setOrders(orders);
        Assert.assertEquals("Warsaw, Koszykowa 86", test_customer.getOrders().get(0).getAddress());
    }




    //setters test
    @Test
    public void testSetFName() throws NameException {
        test_customer.setFirstName("John");
        Assert.assertEquals("John", test_customer.getFirstName());
    }

    @Test
    public void testSetLName() throws SurnameException {
        test_customer.setLastName("Smith");
        Assert.assertEquals("Smith", test_customer.getLastName());
    }

    @Test
    public void testSetEmail() throws EmailException {
        test_customer.setEmail("janedou1@gmail.com");
        Assert.assertEquals("janedou1@gmail.com", test_customer.getEmail());
    }

    @Test
    public void testSetPhone() throws PhoneException {
        test_customer.setPhone("999-999-999");
        Assert.assertEquals("999-999-999", test_customer.getPhone());
    }

    @Test
    public void testSetPassword() throws PasswordException {
        test_customer.setPassword("QwErTy123@4");
        Assert.assertEquals("QwErTy123@4", test_customer.getPassword());
    }

    @Test
    public void testSetDiscount() throws CustomerDiscountException {
        test_customer.setDiscount(0.05);
        Assert.assertEquals(0.05, test_customer.getDiscount(), 0);
    }

    @Test
    public void testSetOrders() {
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order(1L, LocalDateTime.parse("23-12-2021 12:33",formatter), "Warsaw, Koszykowa 86",true));
        test_customer.setOrders(orders);
        Assert.assertEquals("Warsaw, Koszykowa 86", test_customer.getOrders().get(0).getAddress());
    }


    //edit data
    @Test
    public void testEditData() throws NameException, EmailException, PhoneException, PasswordException, SurnameException {
        test_customer.editData("John", null, "jndou567@gmail.com", null, "Aa!123456");
        Assert.assertEquals("John", test_customer.getFirstName());
        Assert.assertEquals("Dou", test_customer.getLastName());
        Assert.assertEquals("jndou567@gmail.com", test_customer.getEmail());
        Assert.assertEquals("000-000-000", test_customer.getPhone());
        Assert.assertEquals("Aa!123456", test_customer.getPassword());
    }

    //log in and sign up
    @Test
    public void testLogInAndSignUp() {
        Assert.assertTrue(test_customer.logIn());
        Assert.assertTrue(test_customer.signUp());
    }
}


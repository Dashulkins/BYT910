import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class OrderTest {
    Order testOrder;
    DateTimeFormatter dateTimeFormatter;
    DateTimeFormatter dateFormatter;

    @Before
    public void setUp() {
        dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        testOrder = new Order(
                1L,
                LocalDateTime.parse("23-12-2021 12:33", dateTimeFormatter),
                "New York, st. Liberty, 14/44",
                true
        );
    }

    @Test
    public void getId() {
        Assert.assertEquals(Long.valueOf(1), testOrder.getId());
        testOrder.setId(4L);
        Assert.assertEquals(Long.valueOf(4), testOrder.getId());
    }

    @Test
    public void getDateOfPlacement() throws TimeAfterNowException {
        Assert.assertEquals("23-12-2021 12:33", testOrder.getDateOfPlacement().format(dateTimeFormatter));
        testOrder.setDateOfPlacement(LocalDateTime.parse("13-02-2022 22:47", dateTimeFormatter));
        Assert.assertEquals("13-02-2022 22:47", testOrder.getDateOfPlacement().format(dateTimeFormatter));
    }

    @Test
    public void getStatus() {
        testOrder.setStatus(Order.Status.ASSEMBLED);
        Assert.assertEquals(Order.Status.ASSEMBLED, testOrder.getStatus());
        testOrder.setStatus(Order.Status.DELIVERED);
        Assert.assertEquals(Order.Status.DELIVERED, testOrder.getStatus());
    }

    @Test
    public void getAddress() throws StringLengthException {
        Assert.assertEquals("New York, st. Liberty, 14/44", testOrder.getAddress());
        testOrder.setAddress("Warsaw, st. Pride 56/89");
        Assert.assertEquals("Warsaw, st. Pride 56/89", testOrder.getAddress());
    }

    @Test
    public void getEstimatedDeliveryDate() {
        testOrder.setEstimatedDeliveryDate(LocalDateTime.parse("28-12-2022 22:47", dateTimeFormatter));
        Assert.assertEquals("28-12-2022 22:47", testOrder.getEstimatedDeliveryDate().format(dateTimeFormatter));
    }

    @Test
    public void getReviews() throws StringLengthException, ReviewRatingException, TimeAfterNowException {
        Review testReview = new Review("""
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve. While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve. While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve. While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                """,
                4.6, LocalDate.parse("23-12-2021", dateFormatter));
        List<Review> reviews = new ArrayList<>();
        reviews.add(testReview);
        testOrder.setReviews(reviews);
        Assert.assertEquals(1, testOrder.getReviews().size());
    }

    @Test
    public void getCustomer() throws EmailException, SurnameException, PhoneException, PasswordException, NameException {
        Customer customer = new Customer("Misha", "Mihailenko", "563-782-098", "mishanya@mail.ru", "Misha456!");
        testOrder.setCustomer(customer);
        Assert.assertEquals("Misha", testOrder.getCustomer().getFirstName());
        Assert.assertEquals("Mihailenko", testOrder.getCustomer().getLastName());
        Assert.assertEquals("563-782-098", testOrder.getCustomer().getPhone());
        Assert.assertEquals("mishanya@mail.ru", testOrder.getCustomer().getEmail());
        Assert.assertEquals("Misha456!", testOrder.getCustomer().getPassword());
    }

    @Test
    public void getItemsWithPrice() throws ShoeSizeException {
        Shoes shoes1 = new Shoes("boots", 4, 45.3, false, 36);
        Shoes shoes2 = new Shoes("heels", 6, 87.9, true, 39);
        List<Shoes> shoesList = new ArrayList<>();
        shoesList.add(shoes1);
        testOrder.setItemsWithPrice(shoesList);
        Assert.assertEquals(1, testOrder.getItemsWithPrice().size());
        shoesList.add(shoes2);
        Assert.assertEquals(2, testOrder.getItemsWithPrice().size());
    }

    @Test
    public void getIsPaid() {
        Assert.assertTrue(testOrder.getIsPaid());
        testOrder.setPaid(false);
        Assert.assertFalse(testOrder.getIsPaid());
    }

    @Test
    public void setId() {
        testOrder.setId(6L);
        Assert.assertEquals(Long.valueOf(6), testOrder.getId());
        testOrder.setId(10L);
        Assert.assertEquals(Long.valueOf(10), testOrder.getId());
    }

    @Test
    public void setAddress() throws StringLengthException {
        testOrder.setAddress("Warsaw, st. Pride 56/89");
        Assert.assertEquals("Warsaw, st. Pride 56/89", testOrder.getAddress());
        boolean isNull = false;
        try {
            testOrder.setAddress("");
        } catch (StringLengthException ignored) {
            isNull = true;
        }
        Assert.assertTrue(isNull);
    }

    @Test
    public void setStatus() {
        testOrder.setStatus(Order.Status.DELIVERED);
        Assert.assertEquals(Order.Status.DELIVERED, testOrder.getStatus());
        testOrder.setStatus(Order.Status.CANCELED);
        Assert.assertEquals(Order.Status.CANCELED, testOrder.getStatus());
    }

    @Test
    public void setDateOfPlacement() throws TimeAfterNowException {
        testOrder.setDateOfPlacement(LocalDateTime.parse("10-01-2022 21:17", dateTimeFormatter));
        Assert.assertEquals("10-01-2022 21:17", testOrder.getDateOfPlacement().format(dateTimeFormatter));
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime future = now.plusMonths(1L);
        boolean isFuture = false;
        try {
            testOrder.setDateOfPlacement(future);
        } catch (TimeAfterNowException ignored) {
            isFuture = true;
        }
        Assert.assertTrue(isFuture);
    }

    @Test
    public void setPaid() {
        testOrder.setPaid(false);
        Assert.assertFalse(testOrder.getIsPaid());
        testOrder.setPaid(true);
        Assert.assertTrue(testOrder.getIsPaid());
    }

    @Test
    public void setEstimatedDeliveryDate() {
        testOrder.setEstimatedDeliveryDate(LocalDateTime.parse("18-10-2022 11:40", dateTimeFormatter));
        Assert.assertEquals("18-10-2022 11:40", testOrder.getEstimatedDeliveryDate().format(dateTimeFormatter));
        testOrder.setEstimatedDeliveryDate(LocalDateTime.parse("28-04-2022 08:23", dateTimeFormatter));
        Assert.assertEquals("28-04-2022 08:23", testOrder.getEstimatedDeliveryDate().format(dateTimeFormatter));
    }

    @Test
    public void setCustomer() throws EmailException, SurnameException, PhoneException, PasswordException, NameException {
        Customer customer1 = new Customer("Misha", "Mihailenko", "563-782-098", "mishanya@mail.ru", "Misha456!");
        testOrder.setCustomer(customer1);
        Assert.assertEquals("mishanya@mail.ru", testOrder.getCustomer().getEmail());
        Assert.assertEquals("Misha456!", testOrder.getCustomer().getPassword());
        Assert.assertEquals("563-782-098", testOrder.getCustomer().getPhone());
        Customer customer2 = new Customer("Maria", "Sulidach", "566-666-098", "mashula@mail.ru", "MashaMasha56!");
        testOrder.setCustomer(customer2);
        Assert.assertEquals("566-666-098", testOrder.getCustomer().getPhone());
        Assert.assertEquals("mashula@mail.ru", testOrder.getCustomer().getEmail());
        Assert.assertEquals("MashaMasha56!", testOrder.getCustomer().getPassword());
    }

    @Test
    public void setItemsWithPrice() throws ShoeSizeException {
        Shoes shoes1 = new Shoes("boots", 4, 45.3, false, 36);
        Shoes shoes2 = new Shoes("heels", 6, 87.9, true, 39);
        List<Shoes> shoesList = new ArrayList<>();
        shoesList.add(shoes1);
        testOrder.setItemsWithPrice(shoesList);
        Assert.assertEquals(4, testOrder.getItemsWithPrice().get(0).getId());
        Assert.assertEquals(36, testOrder.getItemsWithPrice().get(0).getSize());
        Assert.assertFalse(testOrder.getItemsWithPrice().get(0).getCustom());
        shoesList.add(shoes2);
        Assert.assertEquals(6, testOrder.getItemsWithPrice().get(1).getId());
        Assert.assertEquals(39, testOrder.getItemsWithPrice().get(1).getSize());
        Assert.assertTrue(testOrder.getItemsWithPrice().get(1).getCustom());
    }

    @Test
    public void setReviews() throws StringLengthException, ReviewRatingException, TimeAfterNowException {
        Review testReview = new Review("""
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve. While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve. While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve. While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                """,
                4.6, LocalDate.parse("23-12-2021", dateFormatter));
        Review testReview1 = new Review("""
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve. While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve. While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve. While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                """,
                3.2, LocalDate.parse("20-11-2022", dateFormatter));
        List<Review> reviews = new ArrayList<>();
        reviews.add(testReview);
        testOrder.setReviews(reviews);
        Assert.assertEquals(1, testOrder.getReviews().size());
        reviews.add(testReview1);
        Assert.assertEquals(2, testOrder.getReviews().size());
    }

    @Test
    public void orderToString() {
        String expected = "Order{id=1, dateOfPlacement=2021-12-23T12:33, address='New York, st. Liberty, 14/44', estimatedDeliveryDate=null, status=null, isPaid=true}";
        Assert.assertEquals(expected, testOrder.toString());
    }

    @Test
    public void payForOrder() {
        testOrder.payForOrder();
        Assert.assertTrue(testOrder.getIsPaid());
    }

    @Test
    public void placeOrder() {
        testOrder.placeOrder();
        Assert.assertEquals(LocalDateTime.now().format(dateTimeFormatter), testOrder.getDateOfPlacement().format(dateTimeFormatter));
    }

    @Test
    public void provideDeliveryDetails() {
        testOrder.provideDeliveryDetails("Paris, st. Fildjo 63/9");
        Assert.assertEquals("Paris, st. Fildjo 63/9", testOrder.getAddress());
    }

    @Test
    public void cancelOrder() {
        testOrder.cancelOrder();
        Assert.assertEquals("CANCELED", testOrder.getStatus().toString());
    }

    @Test
    public void checkCustomerOrder() {
        testOrder.setStatus(Order.Status.READY_TO_BE_SHIPPED);
        Assert.assertEquals(Order.Status.READY_TO_BE_SHIPPED, testOrder.checkCustomerOrder());
        testOrder.setStatus(Order.Status.SHIPPING);
        Assert.assertEquals(Order.Status.SHIPPING, testOrder.checkCustomerOrder());
    }

    @Test
    public void viewOrder() {
        String expected = "Order{id=1, dateOfPlacement=2021-12-23T12:33, address='New York, st. Liberty, 14/44', estimatedDeliveryDate=null, status=null, isPaid=true}";
        Assert.assertEquals(expected, testOrder.viewOrder());
    }

    @Test
    public void sendToEmployee() {
        Assert.assertTrue(testOrder.sendToEmployee());
    }

    @Test
    public void generateConfirmationLetter() {
        Assert.assertTrue(testOrder.generateConfirmationLetter());
    }

    @Test
    public void updateDeliveryStatus() {
        testOrder.updateDeliveryStatus(Order.Status.ASSEMBLED);
        Assert.assertEquals(Order.Status.ASSEMBLED, testOrder.getStatus());
        testOrder.updateDeliveryStatus(Order.Status.READY_TO_BE_SHIPPED);
        Assert.assertEquals(Order.Status.READY_TO_BE_SHIPPED, testOrder.getStatus());
    }

    @Test
    public void checkDeliveryStatus() {
        testOrder.setStatus(Order.Status.READY_TO_BE_SHIPPED);
        Assert.assertEquals(Order.Status.READY_TO_BE_SHIPPED, testOrder.checkDeliveryStatus());
        testOrder.setStatus(Order.Status.SHIPPING);
        Assert.assertEquals(Order.Status.SHIPPING, testOrder.checkDeliveryStatus());
    }
}

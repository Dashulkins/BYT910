import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;
    private LocalDateTime dateOfPlacement;
    private String address;
    private LocalDateTime estimatedDeliveryDate;
    private Status status;
    private Customer customer;
    private List<Shoes> itemsWithPrice;
    private List<Review> reviews;
    private boolean isPaid;
    
    public enum Status {
        DELIVERED, READY_TO_BE_SHIPPED, SHIPPING, ASSEMBLED, CANCELED
    }

    public void payForOrder() {
        this.isPaid = true;
    }

    public void placeOrder() {
        dateOfPlacement = LocalDateTime.now();
    }

    public void provideDeliveryDetails(String address) {
        this.address = address;
    }

    public void cancelOrder() {
        status = Status.CANCELED;
    }

    public Status checkCustomerOrder() {
        return status;
    }

    public String viewOrder(){

    }

    public boolean sendToEmployee(){

    }

    public boolean generateConfirmationLetter(){

    }

    public void updateDeliveryStatus(){

    }

    public Status checkDeliveryStatus(){

    }
}

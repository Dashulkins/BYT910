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

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateOfPlacement() {
        return dateOfPlacement;
    }

    public Status getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Shoes> getItemsWithPrice() {
        return itemsWithPrice;
    }

    public boolean getIsPaid(){
        return isPaid;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddress(String address) throws StringLengthException {
        if (!address.isEmpty()) {
            this.address = address;
        }else{
            throw new StringLengthException();
        }
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDateOfPlacement(LocalDateTime dateOfPlacement) throws TimeAfterNowException {
        LocalDateTime now = LocalDateTime.now();
        if (dateOfPlacement.isAfter(now)){
            throw new TimeAfterNowException();
        }else {
            this.dateOfPlacement = dateOfPlacement;
        }
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setEstimatedDeliveryDate(LocalDateTime estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateOfPlacement=" + dateOfPlacement +
                ", address='" + address + '\'' +
                ", estimatedDeliveryDate=" + estimatedDeliveryDate +
                ", status=" + status +
                ", isPaid=" + isPaid +
                '}';
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
        return toString();
    }

    public boolean sendToEmployee(){
        return true;
    }

    public boolean generateConfirmationLetter(){
        return true;
    }

    public void updateDeliveryStatus(Status status){

    }

    public Status checkDeliveryStatus(){
        return getStatus();
    }
}

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private double discount;
    private final static double MAX_DISCOUNT = 0.1;
    private List<Order> orders; //association Customer->Orders

    public Customer(String fName, String lName, String phone, String email, String password) throws NameException, EmailException, PhoneException, PasswordException, SurnameException {
        super(fName, lName, phone, email, password);
        discount = 0; //then client login for the first time he has no discounts by default
        orders = new ArrayList<>();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) throws CustomerDiscountException {
        if (discount <= MAX_DISCOUNT) {
            this.discount = discount;
        } else {
            throw new CustomerDiscountException();
        }

    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public void setOrders(List<Order> orders) {
        this.orders = new ArrayList<>(orders);
    }

    @Override
    public String toString() {
        return super.toString() + "Discount: " + discount;
    }
}

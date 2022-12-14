public class Customer extends User{
    private double discount;
    private final static double MAX_DISCOUNT = 0.1;

    public Customer(String fName, String lName, String phone, String email, String password) throws UserNameException, UserEmailException, UserPhoneException, UserPasswordException, UserSurnameException {
        super(fName, lName, phone, email, password);
        discount = 0; //then client login for the first time he has no discounts by default
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) throws CustomerDiscountException {
        if(discount <= MAX_DISCOUNT) {
            this.discount = discount;
        } else {
            throw new CustomerDiscountException();
        }

    }

    @Override
    public String toString() {
        return super.toString() + "Discount: " + discount;
    }
}

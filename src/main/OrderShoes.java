import java.util.ArrayList;
import java.util.List;

public class OrderShoes {
private Order order;
private List<Shoes> shoes;

private int amount;
private double totalCost;


public OrderShoes(Order order, ArrayList<Shoes> shoes) {
    this.order = order;
    this.shoes.addAll(shoes);
    amount = this.shoes.size();
    this.totalCost = CalculateTotalCost();

}

public double CalculateTotalCost() {
    return this.shoes.stream().map(Shoes::getPrice).reduce(Double::sum).orElse(.0);
}


}

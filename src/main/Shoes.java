public class Shoes {
    private String name;
    private int id;
    private double price;
    private boolean isCustom;
    private int size;

Shoes(String name,int id,double price, boolean isCustom, int size){
    this.name = name;
    this.id = id;
    this.price = price;
    this.isCustom = isCustom;
    this.size = size;
}
public String getName(){
    return name;
}
public int getId(){
    return id;
}
public double getPrice(){
    return price;
}
public  boolean getCustom(){
    return isCustom;
}
public int getSize(){
    return size;
}
public void setName(String name){
    this.name = name;
}
public void setId(int id){
    this.id = id;
}
public void setPrice(double price){
    this.price = price;
}
public void setCustom(boolean isCustom){
    this.isCustom = isCustom;
}
public void setSize(int size){
    this.size = size;
}
public void changeProductDetails(Shoes shoes, double price,boolean isCustom,int size){
    shoes.setName(name);
    shoes.setPrice(price);
    shoes.setCustom(isCustom);
    shoes.setSize(size);
}
}

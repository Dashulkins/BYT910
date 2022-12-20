import java.lang.Exception;
public class Shoes {
    private String name;
    private int id;
    private double price;
    private boolean isCustom;
    private int size;

Shoes(String name,int id,double price, boolean isCustom, int size) throws ShoeSizeException{
    this.name = name;
    this.id = id;
    this.price = price;
    this.isCustom = isCustom;
    this.setSize(size);
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
public void setSize(int size) throws ShoeSizeException{
    if(size<36 || size>45){
        throw new ShoeSizeException();
    }else {
        this.size = size;
    }
}
public void changeProductDetails(String name,int id,double price, boolean isCustom, int size) throws ShoeSizeException {

       setName(name);
       setId(id);
       setPrice(price);
       setCustom(isCustom);
       setSize(size);
}
public boolean listAllBestSellers(){
    return true;
}
}

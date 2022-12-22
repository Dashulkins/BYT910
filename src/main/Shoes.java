
public class Shoes {

    enum Size{
        Size_35(35), Size_36(36), Size_37(37), Size_38(38), Size_39(39),
        Size_40(40),Size_41(41);
        private final int size_num;
        Size(int size_num) {
            this.size_num = size_num;
        }
    }

    private String name;
    private int id;
    private String img;
    private double price;
    private boolean isCustom;
    private Size size;

    Shoes(String name, int id, double price, boolean isCustom, Size size, String img) throws ShoeSizeException {
        this.name = name;
        this.id = id;
        this.price = price;
        this.isCustom = isCustom;
        this.img = img;
        this.setSize(size);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public boolean getCustom() {
        return isCustom;
    }

    public Size getSize() {
        return size;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isCustom() {
        return isCustom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCustom(boolean isCustom) {
        this.isCustom = isCustom;
    }

    public void setSize(Size size) throws ShoeSizeException {
        this.size = size;
    }

    public void changeProductDetails(String name, int id, double price, boolean isCustom, Size size) throws ShoeSizeException {
        setName(name);
        setId(id);
        setPrice(price);
        setCustom(isCustom);
        setSize(size);
    }

    public boolean listAllBestSellers() {
        return true;
    }
}

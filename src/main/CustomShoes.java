public class CustomShoes extends Shoes{
    private String description;
    private boolean img;
    private String custom_type;
    CustomShoes(String name, int id, double price, boolean isCustom, int size,String description,boolean img, String custom_type) {
        super(name, id, price, true, size);
        this.description = description;
        this.img = img;
        this.custom_type = custom_type;
    }

    public String getDescription() {
        return description;
    }

    public boolean getImg() {
        return img;
    }

    public String getCustom_type() {
        return custom_type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImg(boolean img) {
        this.img = img;
    }

    public void setCustom_type(String custom_type) {
        this.custom_type = custom_type;
    }
    public CustomShoes CreateCustomShoes(Shoes shoes,String description,boolean img,String custom_type){
      return new CustomShoes(shoes.getName(),shoes.getId(),shoes.getPrice(),true,shoes.getSize(),description,img,custom_type);
    }
}

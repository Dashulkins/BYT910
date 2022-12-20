
public class CustomShoes {
    private String description;
    private boolean img;
    private Shoes shoes;
    private String custom_type;
    CustomShoes(String description,boolean img, String custom_type) {
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
    public boolean CreateCustomShoes(){
        return true;
    }
}

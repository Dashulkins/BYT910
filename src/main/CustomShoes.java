public class CustomShoes {
    private String description;
    private boolean img;
    private Shoes shoes;
    private String customType;

    CustomShoes(String description, boolean img, String customType) {
        this.description = description;
        this.img = img;
        this.customType = customType;
    }

    public String getDescription() {
        return description;
    }

    public boolean getImg() {
        return img;
    }

    public String getCustomType() {
        return customType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImg(boolean img) {
        this.img = img;
    }

    public void setCustomType(String customType) {
        this.customType = customType;
    }

    public boolean CreateCustomShoes() {
        return true;
    }
}

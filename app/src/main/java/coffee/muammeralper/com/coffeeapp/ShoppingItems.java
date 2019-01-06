package coffee.muammeralper.com.coffeeapp;

public class ShoppingItems {
    private String name;
    private String pirce;
    private String desc, image;


    public ShoppingItems(String name, String price, String desc, String image) {
        this.name = name;
        this.pirce = price;
        this.desc = desc;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPirce() {
        return pirce;
    }

    public void setPirce(String pirce) {
        this.pirce = pirce;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

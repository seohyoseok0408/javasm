package dto;

import java.util.Date;

public class Item {
    private int id;
    private String name;
    private int price;
    private Date registrationDate;
    private String imageName;

    public Item() {}
    public Item(int id, String name, int price, String imageName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.registrationDate = new Date();
        this.imageName = imageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", registrationDate='" + registrationDate + '\'' +
                ", imageName='" + imageName + '\'' +
                '}';
    }
}

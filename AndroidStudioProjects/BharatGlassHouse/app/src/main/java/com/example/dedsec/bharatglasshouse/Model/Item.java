package com.example.dedsec.bharatglasshouse.Model;

public class Item {
    private String Name, Image, Description, Price, Discount, MenuID, Quantity;

    public Item() {

    }

    public Item(String name, String image, String description, String price, String discount, String menuID, String Quantity) {
        Name = name;
        Image = image;
        Description = description;
        Price = price;
        Discount = discount;
        MenuID = menuID;
        this.Quantity = Quantity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getMenuID() {
        return MenuID;
    }

    public void setMenuID(String menuID) {
        MenuID = menuID;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }
}

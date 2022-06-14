package ru.netology;

public class Product {
    private static final char RUB = (char) 0x20BD;
    private int id;
    private String name;
    private String productName;
    private String manufacturer;
    private String country;
    private double price;

    public Product() {
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public Product setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Product setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getPrice() {
        return String.valueOf(price);
    }

    public String print() {
        return name + " - " +
                productName +
                ", Производитель: " + manufacturer +
                ", Cтрана: " + country +
                ", Цена: " + price + " " + RUB;
    }

    @Override
    public String toString() {
        return getId() + ". " +
                name + " - " +
                productName +
                ", Производитель: " + manufacturer +
                ", Cтрана: " + country +
                ", Цена: " + price + " " + RUB;
    }
}

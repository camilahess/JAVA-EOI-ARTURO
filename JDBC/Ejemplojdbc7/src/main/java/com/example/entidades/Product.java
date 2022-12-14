package com.example.entidades;

public class Product {
    private int id;
    private String reference;
    private String name;
    private double price;
    private int category;


    public Product(int id, String reference, String name, double price, int category) {
        this.id = id;
        this.reference = reference;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product () {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", reference=" + reference + ", name=" + name + ", price=" + price + ", category="
                + category + "]";
    }

    
}


package com.xdee.lab1_datnxph36362.DTO;

public class ProductDTO {
    int id, price, id_cat;
    String name;

    public ProductDTO(int id, int price, int id_cat, String name) {
        this.id = id;
        this.price = price;
        this.id_cat = id_cat;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

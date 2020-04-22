package com.example.dispatchproject;

public class DataModel {
    String product_name;
    String product_price;

    public DataModel(String product_name, String product_price)
    {
        this.product_name = product_name;
        this.product_price = product_price;
    }


    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_price() {
        return product_price;
    }
}

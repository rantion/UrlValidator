package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 10/17/13
 * Time: 8:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class InvoiceItems {

    private String description;
    private int quantity;
    private double price;

    public InvoiceItems(String _description, int _quantity, double _price){
        description = _description;
        quantity = _quantity;
        price = _price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

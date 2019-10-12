package com.oswal.stockmangmentnew.POJO;

public class Item {

    String model_number, serial_number, category, quantity, date;
    ItemSpecification itemSpecification = new ItemSpecification();


    public String getModel_number() {
        return model_number;
    }

    public void setModel_number(String model_number) {
        this.model_number = model_number;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public ItemSpecification getItemSpecification() {
        return itemSpecification;
    }

    public void setItemSpecification(ItemSpecification itemSpecification) {
        this.itemSpecification = itemSpecification;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

package com.oswal.stockmangmentnew.POJO;

public class Item {

    String name, model_number, serial_number, DOM, supplier_name, mobile_number, storage_location, category,quantity;
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

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getStorage_location() {
        return storage_location;
    }

    public void setStorage_location(String storage_location) {
        this.storage_location = storage_location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDOM() {
        return DOM;
    }

    public void setDOM(String DOM) {
        this.DOM = DOM;
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
}

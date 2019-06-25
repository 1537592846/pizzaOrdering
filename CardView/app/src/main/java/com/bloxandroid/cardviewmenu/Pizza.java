package com.bloxandroid.cardviewmenu;

public class Pizza {
    private String name;
    private int imageResource;
    private double price;
    private double delivery_fee;
    private double couponDiscount;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(double delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public String getDelivery_feeString() {
        return "R$ "+delivery_fee;
    }

    public double getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public String getCouponDiscountString(){
        return "R$ "+couponDiscount;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceString() {
        return "R$ "+price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Pizza(String name, int imageResource, double price,double delivery_fee) {
        this.name = name;
        this.imageResource = imageResource;
        this.price = price;
        this.delivery_fee=delivery_fee;
        this.couponDiscount=0;
    }

    public String getFinalPrice(){
        double finalPrice=this.price+this.delivery_fee-this.couponDiscount;
        return "R$ "+finalPrice;
    }
}
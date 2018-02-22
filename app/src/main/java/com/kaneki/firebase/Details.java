package com.kaneki.firebase;

public class Details {
    public String id;
    public String med_name ;
    public String address;
    public int quantity;
    public int exp_month;
    public int exp_year;

    public Details() {
    }

    public Details(String id, String med_name, String address, int quantity, int exp_month, int exp_year) {
        this.id = id;
        this.med_name = med_name;
        this.address = address;
        this.quantity = quantity;
        this.exp_month = exp_month;
        this.exp_year = exp_year;
    }
}

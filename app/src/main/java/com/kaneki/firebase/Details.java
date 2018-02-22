package com.kaneki.firebase;

public class Details {
    public String med_name ;
    public String address;
    public Double quantity;
    public Double exp_month;
    public Double exp_year;

    public Details() {
    }

    public Details(String med_name, String address, Double quantity, Double exp_month, Double exp_year) {
        this.med_name = med_name;
        this.address = address;
        this.quantity = quantity;
        this.exp_month = exp_month;
        this.exp_year = exp_year;
    }
}

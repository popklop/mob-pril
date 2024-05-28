package com.example.pr12;

public class Car
{
    public String brand;
    public int build_year;
    public String type;
    Car(String brand, int build_year, String type)
    {
        this.brand=brand;
        this.build_year=build_year;
        this.type=type;
    }

    public int getBuild_year()
    {
        return build_year;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getType()
    {
        return type;
    }
}

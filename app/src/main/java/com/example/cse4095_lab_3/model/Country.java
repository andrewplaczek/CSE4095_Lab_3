package com.example.cse4095_lab_3.model;

import java.util.ArrayList;

public class Country {
    private String name;
    private String capital;
    private String region;
    private String subregion;
    private int population;
    //Area in km^2
    private double area;
    private ArrayList<String> borders;
    private ArrayList<String> languages;




    public Country(String name, String capital, String region, String subregion, int population, double area, ArrayList<String> borders, ArrayList<String> languages){
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.borders = borders;
        this.area = area;
        this.languages = languages;
    }

    public String getName(){
        return name;
    }

    public String getCapital(){
        return capital;
    }

    public String getRegion(){
        return region;
    }

    public String getSubregion(){ return subregion; }

    public int getPopulation() {return population; }

    public ArrayList<String> getBorders() { return borders;}

    public double getArea(){ return area;}

    public ArrayList<String> getLanguages(){return languages;}


}


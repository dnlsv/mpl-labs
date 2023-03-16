package org.example;

public class Planet {

    private String name;
    private double square;

    public Planet() {

    }

    public Planet(String name, double square) {
        this.name = name;
        this.square = square;
    }

    @Override
    public String toString() {
        return "Название: " + name + ", Площадь планеты: " + square;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

}

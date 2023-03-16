package org.example;

public class Area {
    private double square;
    private int cost;
    private String landscape;

    public Area() {

    }

    public Area(double square, int cost, String landscape) {
        this.square = square;
        this.cost = cost;
        this.landscape = landscape;
    }

    @Override
    public String toString() {
        return "Площадь: " + square + ", Стоимость: " + cost + ", Ландшафт: " + landscape;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getLandscape() {
        return landscape;
    }

    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }

}

package oop2;

import java.util.Random;

public class Car {
    private int serial;
    private String name;
    private String color;
    private double fuelSize;
    private double currFuel;

    public Car() {
        Random rand = new Random();
        this.serial = rand.nextInt(10000)+1;
    }
    public Car(int serial, String name, String color, double fuelSize, double currFuel) {
        this.serial = serial;
        this.name = name;
        this.color = color;
        this.fuelSize = fuelSize;
        this.currFuel = currFuel;
    }

    public Car(String name, String color, double fuelSize, double currFuel) {
        this();
        this.name = name;
        this.color = color;
        this.fuelSize = fuelSize;
        this.currFuel = currFuel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "serial=" + serial +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", fuelSize=" + fuelSize +
                ", currFuel=" + currFuel +
                '}';
    }

    public void setCurrFuel(double currFuel) {
        this.currFuel = currFuel;
    }

    public void go(int distance) {
        this.currFuel -= distance/100.0;
        System.out.printf("%s %d 달렸습니다.\n", this.name, distance);
    }

    public void brake() {
        System.out.printf("Brake:::: %s \n", this.toString());
    }

    public void addFuel(double size) throws Exception {
        if (this.currFuel + size > this.fuelSize) {
            throw new Exception("EC0001");
        }
        this.currFuel += size;
    }
}

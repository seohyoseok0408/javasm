package oop1;

public class Car {
    private int serial;
    private String name;
    private String color;

    public Car() {
        serial = 0;
    }

    public Car(String color, String name) {
        this();
        this.color = color;
        this.name = name;
    }

    public Car(int serial, String name, String color) {
        this.serial = serial;
        this.name = name;
        this.color = color;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "serial=" + serial +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public void go() {
        System.out.println("부우우우웅~");
    }

    public void brake() {
        System.out.println("끼이이이익");
    }
}

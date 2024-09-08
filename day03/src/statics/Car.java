package statics;

public class Car {
    private int serial;
    private String name;
    private String color;

    public static String vendor = "Toyota";
    public static int count = 0;

    static  {
        System.out.println("Static block");
        System.out.println("Loading... Car class");
    }

    public Car() {}

    public Car(String name, String color) {
        this.serial = ++count;
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", serial=" + serial +
                ", name='" + name + '\'' +
                '}';
    }
}

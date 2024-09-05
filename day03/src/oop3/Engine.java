package oop3;

public class Engine {
    private int serial;
    private String name;
    private String rarity;

    public Engine(int serial, String name, String rarity) {
        this.serial = serial;
        this.name = name;
        this.rarity = rarity;
    }

    public void start() {
        System.out.println("엔진 가동 : " + name);
    }

    public void stop() {
        System.out.println("엔진 종료 : " + name);
    }
}

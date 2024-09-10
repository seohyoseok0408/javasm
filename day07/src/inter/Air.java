package inter;

public class Air implements Remote{

    @Override
    public void turnOn() {
        System.out.println("Turning on air");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off air");
    }
}

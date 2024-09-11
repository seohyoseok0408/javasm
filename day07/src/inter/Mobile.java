package inter;

public class Mobile {
    public static void main(String[] args) {
        Remote remote = new Tv();
        remote.turnOn();
        remote.turnOff();;

        Bluetooth bluetooth = new Tv();
        bluetooth.on();
        bluetooth.paring();
    }
}

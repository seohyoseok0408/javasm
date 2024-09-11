package inter;

public class Tv implements Remote, Bluetooth{

    // 반드시 Tv 안에는 Remote 에 있는 2개의 함수를 구현해야만 한다.
    @Override
    public void turnOn() {
        System.out.println("turning on Tv!!");
    }

    @Override
    public void turnOff() {
        System.out.println("turning off Tv!!");
    }

    @Override
    public void paring() {
        System.out.println("paring Tv!!");
    }
}

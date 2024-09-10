package inter;

public interface Bluetooth {
    void paring();

    default void on(){
        System.out.println("On");
    }
}

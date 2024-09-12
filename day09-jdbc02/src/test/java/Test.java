import edu.sm.dto.Cust;

public class Test {
    public static void main(String[] args) {
        Cust cust = new Cust("1", "pwd01", "name");
        System.out.println(cust.toString());

        Cust c = Cust.builder()
                .id("2")
                .pwd("pwd02")
                .name("hyoseok")
                .build();

        System.out.println(c.toString());

    }
}

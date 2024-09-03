package op;

public class Op1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        if(a++ > 0 | b++ < 0){
            System.out.println("ok");
        }else{
            System.out.println("fail");
        }
        System.out.printf("%d, %d\n", a, b);
    }
}
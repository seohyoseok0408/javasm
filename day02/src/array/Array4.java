package array;

public class Array4 {
    public static void main(String[] args) {
        int a[] = new int[5]; // 배열은 반드시 처음에 사이즈를 가져야 한다.
        int b[] = {1, 2, 3, 4, 5}; // 선언과 동시에 초기화
        int c[] = new int[]{1, 2, 3, 4, 5};

        int d[][] = new int[2][]; // 2행짜리 배열만 선언도 가능
        d[0] = new int[10];
        d[1] = new int[5];

        int e[][] = {{1,2}, {3,4,5}};
        int f[][] = new int[][]{{1,2}, {3,4,5}};

        int g[][]; // 초기화가 안된 상태
//        g = {{1,2,3}, {4,5,6}}; // 이렇게 하면 안됨 -> 이유 정확하게 알자
        /*
        중괄호 사용은 선언과 동시에 초기화를 할 때만 허용된다.
        이미 선언된 배열을 초기화하기 위해서는 new 연산자를 사용해야 한다.
         */
    }
}

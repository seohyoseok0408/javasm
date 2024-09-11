package collection;

import java.util.*;

public class Col1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(780); // Promotion 된 모 = 자동 타입 변환
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4); // 중복 허용, 순서 유지

        System.out.println(list);

        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(3);
        set.add(1);
        set.add(2);
        System.out.println(set); // 순서유지 X, 중복허용 X

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        System.out.println(map);
        System.out.println(map.get("a")); // 키값에 해당하는 데이터 꺼내기
    }
}

package workshop;// 테스트 클래스
public class Main {
    public static void main(String[] args) {
        // Zombie와 Plant 객체들을 배열에 추가
        Unit[] units = new Unit[4];

        // 각 객체 추가 (FootballZombie, ConeheadZombie, Peashooter, Sunflower)
        units[0] = new FootballZombie();  // 좀비
        units[1] = new ConeheadZombie();  // 좀비
        units[2] = new Peashooter();      // 식물
        units[3] = new Sunflower();       // 식물

        // 모든 유닛의 특수 스킬 사용
        System.out.println("Testing special skills:");
        for (Unit unit : units) {
            unit.use_special_skill();
        }

        // 식물의 shoot 메서드 사용 테스트
        System.out.println("\nTesting shoot for plants:");
        for (Unit unit : units) {
            if (unit instanceof Plant) {
                Plant plant = (Plant) unit;
                plant.shoot();  // 식물이 원거리 공격을 하는 것을 명시적으로 표현
            }
        }

        // 좀비와 식물 간의 공격 테스트
        System.out.println("\nTesting attack interactions:");
        for (int i = 0; i < units.length; i++) {
            if (i % 2 == 0) {  // Zombie (짝수 인덱스)
                System.out.println("\n" + units[i].getName() + " is attacking " + units[i + 1].getName());
                units[i].attack(units[i + 1]);  // Zombie가 Plant를 공격
            } else {  // Plant (홀수 인덱스)
                System.out.println(units[i].getName() + " is retaliating against " + units[i - 1].getName());
                units[i].attack(units[i - 1]);  // Plant가 Zombie를 공격
            }
        }

        // Sunflower가 Peashooter를 치유하는 테스트
        System.out.println("\nTesting Sunflower's healing ability:");
        Sunflower sunflower = (Sunflower) units[3];
        Peashooter peashooter = (Peashooter) units[2];
        sunflower.healAlly(peashooter);

        // 유닛들의 현재 체력 상태 확인
        System.out.println("\nHealth status after attacks:");
        for (Unit unit : units) {
            System.out.println(unit.getName() + " has " + unit.getHp() + " HP remaining.");
        }
    }
}
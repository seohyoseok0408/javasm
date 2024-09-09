package workshop;

// Sunflower 클래스 (식물): 치유량을 저장하는 변수 추가
class Sunflower extends Plant {
    private int healingAmount;  // 아군을 치유하는 양

    public Sunflower() {
        super("Sunflower", 80, 0, 3, 0);  // 공격력이 없는 대신 방어력이 높음
        this.healingAmount = 10;  // 아군을 치유하는 기본 회복량
    }

    @Override
    public void use_special_skill() {
        System.out.println(getName() + " generates extra sun points to support other plants!");
    }

    // 아군 식물의 체력을 회복하는 능력 추가
    public void healAlly(Plant ally) {
        System.out.println(getName() + " heals " + ally.getName() + " for " + healingAmount + " HP!");
        ally.setHp(ally.getHp() + healingAmount);
    }

    // 치유량 설정 메서드
    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }

    public int getHealingAmount() {
        return healingAmount;
    }
}

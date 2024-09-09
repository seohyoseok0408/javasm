package workshop;


// Peashooter 클래스 (식물): 연속 공격 스택을 추적하는 변수 추가
class Peashooter extends Plant {
    private int attackStreak;  // 연속 공격 횟수
    private int bonusDamagePerStreak;  // 연속 공격 시 추가되는 데미지 양

    public Peashooter() {
        super("Peashooter", 100, 15, 5, 10);
        this.attackStreak = 0;
        this.bonusDamagePerStreak = 2;  // 연속 공격 시 2씩 추가 피해
    }

    @Override
    public void use_special_skill() {
        System.out.println(getName() + " fires a powerful pea shot!");
    }

    // 공격할 때마다 연속 공격 시 공격력이 증가하는 특수 능력 추가
    @Override
    public void attack(Unit target) {
        attackStreak++;
        int bonusDamage = attackStreak * bonusDamagePerStreak;  // 연속 공격에 따른 추가 피해
        setAttack_damage(getAttack_damage() + bonusDamage);
        System.out.println(getName() + " deals an additional " + bonusDamage + " damage for a total of " + getAttack_damage() + " damage due to attack streak!");
        super.attack(target);
        setAttack_damage(getAttack_damage() - bonusDamage);  // 원래 공격력으로 되돌리기
    }

    // 연속 공격 스택 리셋 메서드 (예: 전투 종료 시)
    public void resetAttackStreak() {
        attackStreak = 0;
    }

    // 보너스 데미지 설정 메서드
    public void setBonusDamagePerStreak(int bonusDamagePerStreak) {
        this.bonusDamagePerStreak = bonusDamagePerStreak;
    }

    public int getBonusDamagePerStreak() {
        return bonusDamagePerStreak;
    }
}
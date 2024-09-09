package workshop;

// ConeheadZombie 클래스 (좀비): 방어력 증가와 관련된 변수 추가
public class ConeheadZombie extends Zombie {
    private int defenseIncrease;  // 방어력 증가량

    public ConeheadZombie() {
        super("Conehead Zombie", 200, 15, 20, 2);
        this.defenseIncrease = 5;  // 방어력 증가량
    }

    @Override
    public void use_special_skill() {
        System.out.println(getName() + " uses its conehead to absorb more damage!");
    }

    // 공격할 때 50% 확률로 방어력이 증가하는 특수 능력 추가
    @Override
    public void attack(Unit target) {
        super.attack(target);
        if (Math.random() < 0.5) {  // 50% 확률
            setDefense(getDefense() + defenseIncrease);
            System.out.println(getName() + " gains " + defenseIncrease + " defense after the attack!");
        }
    }

    // 방어력 증가량 설정 메서드
    public void setDefenseIncrease(int defenseIncrease) {
        this.defenseIncrease = defenseIncrease;
    }

    public int getDefenseIncrease() {
        return defenseIncrease;
    }
}

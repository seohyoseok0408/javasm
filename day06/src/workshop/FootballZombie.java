package workshop;

// FootballZombie 클래스 (좀비): 공격할 때 체력을 회복하는 능력 추가
public class FootballZombie extends Zombie {
    private int healingAmount;  // 공격 시 회복하는 체력량

    public FootballZombie() {
        super("Football Zombie", 150, 20, 10, 5);
        this.healingAmount = 5;  // 공격 시 5만큼 체력을 회복
    }


    @Override
    public void use_special_skill() {
        System.out.println(getName() + " charges forward at high speed!");
    }

    // 공격할 때 체력을 회복하는 능력 추가
    @Override
    public void attack(Unit target) {
        super.attack(target);
        heal(healingAmount);  // 공격할 때 healingAmount만큼 체력 회복
        System.out.println(getName() + " heals for " + healingAmount + " HP after the attack!");
    }
    // 체력을 회복하는 메서드
    public void heal(int amount) {
        setHp(getHp() + amount);
    }
    // 회복량 설정 메서드
    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }

    public int getHealingAmount() {
        return healingAmount;
    }
}


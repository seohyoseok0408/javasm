package workshop;

public abstract class Unit {
    private String name;
    private int hp;
    private int attack_damage;
    private int defense;

    public Unit() {}

    public Unit(String name, int hp, int attack_damage, int defense) {
        this.name = name;
        this.hp = hp;
        this.attack_damage = attack_damage;
        this.defense = defense;
    }
    public void attack(Unit target) {
        int damage = Math.max(0, this.attack_damage - target.getDefense());
        target.setHp(target.getHp() - damage);
        System.out.println(this.name + " 는 " + target.getName() + " 을 " + damage + " 데미지로 공격했다.");
    }

    // 추상메서드 : 하위클래스에서 구현해야함
    abstract void use_special_skill();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack_damage() {
        return attack_damage;
    }

    public void setAttack_damage(int attack_damage) {
        this.attack_damage = attack_damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}

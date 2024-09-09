package workshop;

class Plant extends Unit {
    private int range_attack;

    public Plant(String name, int hp, int attack_damage, int defense, int range_attack) {
        super(name, hp, attack_damage, defense);
        this.range_attack = range_attack;
    }

    public int getRangeAttack() {
        return range_attack;
    }

    public void setRangeAttack(int range_attack) {
        this.range_attack = range_attack;
    }

    @Override
    public void use_special_skill() {
        System.out.println(getName() + " 레전드 식물 스킬 사용 !!!");
    }

    // 식물 발사 메서드
    public void shoot() {
        System.out.println(getName() + " 발사체 발사 !! :  " + range_attack);
    }
}

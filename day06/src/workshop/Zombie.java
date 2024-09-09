package workshop;

class Zombie extends Unit {
    private int speed;

    public Zombie(String name, int hp, int attack_damage, int defense, int speed) {
        super(name, hp, attack_damage, defense);
        this.speed = speed; // 좀비는 이동 가능
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void use_special_skill() {
        System.out.println(getName() + "좀비의 레전드 스킬을 이용해 방어를 무너뜨립니다!");
    }

    // 좀비 이동 메서드
    public void move() {
        System.out.println(getName() + "빠른 속도로 천천히 앞으로 나아간다.. :  " + speed);
    }
}
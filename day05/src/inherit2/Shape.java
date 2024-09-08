package inherit2;

public abstract class Shape {
    protected int x;
    protected int y;
    public Shape() {}
    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "X: " + x + ", Y: " + y;
    }

    // Abstract Method
    // Must
    public abstract double getArea();
    public abstract double getCircum();
}
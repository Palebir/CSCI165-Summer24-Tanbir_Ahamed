public class MovablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    // No-argument constructor
    public MovablePoint() {
        this(0, 0, 0.0f, 0.0f);
    }

    // Constructor with parameters
    public MovablePoint(int x, int y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    // Copy constructor
    public MovablePoint(MovablePoint other) {
        this(other.getX(), other.getY(), other.xSpeed, other.ySpeed);
    }

    // Getter for xSpeed
    public float getXSpeed() {
        return xSpeed;
    }

    // Setter for xSpeed
    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    // Getter for ySpeed
    public float getYSpeed() {
        return ySpeed;
    }

    // Setter for ySpeed
    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    // Method to get speeds as an array
    public float[] getSpeeds() {
        return new float[]{xSpeed, ySpeed};
    }

    // Override toString method
    @Override
    public String toString() {
        return super.toString() + ": speed = (" + xSpeed + ", " + ySpeed + ")";
    }

    // Method to move the point
    public MovablePoint move() {
        setXY(getX() + (int) xSpeed, getY() + (int) ySpeed);
        return this;
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        MovablePoint that = (MovablePoint) obj;
        return Float.compare(that.xSpeed, xSpeed) == 0 && Float.compare(that.ySpeed, ySpeed) == 0;
    }
}

import java.util.Objects;

public class MenuItem implements Comparable<MenuItem> {
    private String name;
    private double price;
    private int calories;

    // No-argument constructor with default values
    public MenuItem() {
        this.name = "";
        this.price = 1.00;
        this.calories = 0;
    }

    // Overloaded constructor with validation
    public MenuItem(String name, double price, int calories) {
        setName(name);
        setPrice(price);
        setCalories(calories);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            this.price = 1.00;
        } else {
            this.price = price;
        }
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        if (calories < 0) {
            this.calories = 0;
        } else {
            this.calories = calories;
        }
    }

    // toString method
    @Override
    public String toString() {
        return String.format("MenuItem [name=%s, price=%.2f, calories=%d]", name, price, calories);
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MenuItem other = (MenuItem) obj;
        return Double.compare(other.price, price) == 0 &&
                calories == other.calories &&
                Objects.equals(name, other.name);
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(name, price, calories);
    }

    // compareTo method
    @Override
    public int compareTo(MenuItem other) {
        return Integer.compare(other.getCalories(), this.calories);
    }
}

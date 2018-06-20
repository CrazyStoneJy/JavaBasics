package generic;

/**
 * Created by crazystone on 18-3-14.
 */
public class Plate<T> {
    T food;

    public Plate(T food) {
        this.food = food;
    }

    public Plate() {
    }

    public T getFood() {
        return food;
    }

    public Plate setFood(T food) {
        this.food = food;
        return this;
    }
}

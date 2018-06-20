package reflection.basic;

import java.util.Random;

/**
 * Created by crazystone on 18-6-19.
 */
public class Person implements Doable{

    static int commonVar = 11;
    private static int staticVar = 1;

    static {
        System.out.println("this static block");
        staticVar = 2;
    }

    public float weight; // unit is kg
    protected String name;
    int height; // unit is cm
    private int age;
    private Random random = new Random();

    {
        System.out.println("this is common block");
        commonVar = 12;
    }

    public Person(String name, int age, int height, float weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        System.out.println("this is constructor with parameter");
    }

    public Person() {
        System.out.println("this is constructor");
    }

    public void eat() {
        System.out.println(this.name + " is eating");
    }

    private void sleep() {
        System.out.println(this.name + " is sleeping");
    }

    float earnMoney() {
        int money = random.nextInt(10 * 1000);
        System.out.println(this.name + " earn " + money + "$");
        return money;
    }


}

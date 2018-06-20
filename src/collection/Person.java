package collection;

/**
 * Created by crazystone on 18-5-23.
 */
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return p.getName().equals(getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int a = age;
        int b = getName().length();
        return (a << b) % Integer.MAX_VALUE;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

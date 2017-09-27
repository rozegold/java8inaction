package Application.java8;

import java.math.BigDecimal;

public class Developer {

    private String name;
    private int age;
    private BigDecimal salary;

    public Developer(String name, int age, BigDecimal salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}

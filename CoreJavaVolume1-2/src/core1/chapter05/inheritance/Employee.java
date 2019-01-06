package core1.chapter05.inheritance;


import java.time.LocalDate;

class A {
    public int i = 10;



    public String getAAA() {
        return "AAA";
    }
    public static String getAA() {
        return "AA";
    }
}

class B extends A {
    public String getAAA() {
        return "AAA";
    }
}

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee() {
    }

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public static String getName() {
        return "";
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public static void main(String[] args) {
        A e = new A();
        System.out.println(A.getAA());
        System.out.println(e.getAA());

        StringBuffer s1 = new StringBuffer("s");
        StringBuffer s2 = new StringBuffer("t");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}

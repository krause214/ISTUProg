package istu_oop_java_lab1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Person petr = new Person("Петр", "Карпов", "Николаевич", 32);
        Person konstantin = new Person("Константин", "Хугаев", "Владиславович", 15);

        System.out.println(petr.toString());
        System.out.println(konstantin.toString());

        Vehicle car = new Vehicle(CarModel.AUDI, "C123EX");
        car.setDriver(petr);
        System.out.println(car.toString());
    }
}
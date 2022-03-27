package istu_oop_lab2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        Figure firstFigure;
        Figure secondFigure;
        switch (Math.abs(r.nextInt()) % 3) {
            case 0:
                firstFigure = new Ellipse(r.nextDouble(), r.nextDouble());
                break;
            case 1:
                firstFigure = new Rectangle(r.nextDouble(), r.nextDouble());
                break;
            case 2:
                firstFigure = new Triangle(r.nextDouble(), r.nextDouble());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + r.nextInt() % 3);
        }

        switch (Math.abs(r.nextInt()) % 3) {
            case 0:
                secondFigure = new Ellipse(r.nextDouble(), r.nextDouble());
                break;
            case 1:
                secondFigure = new Rectangle(r.nextDouble(), r.nextDouble());
                break;
            case 2:
                secondFigure = new Triangle(r.nextDouble(), r.nextDouble());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + r.nextInt() % 3);
        }

        System.out.println("First figure (" + firstFigure.toString() + ")");
        System.out.println("Second figure (" + secondFigure.toString() + ")");

        if (firstFigure.getArea() > secondFigure.getArea()) {
            System.out.println("First figure (" + firstFigure.getTypeOfFigure() + ") is biggest");
        }
        else {
            System.out.println("Second figure (" + secondFigure.getTypeOfFigure() + ") is biggest");
        }
    }
}
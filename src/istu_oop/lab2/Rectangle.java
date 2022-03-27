package istu_oop_lab2;

public class Rectangle extends Figure {
    Double a;
    Double b;

    public Rectangle(Double a, Double b){
        this.a = a;
        this.b = b;
        findArea();
    }

    @Override
    public void findArea(){
        setArea(a * b);
    }

    @Override
    public String getTypeOfFigure() {
        return "Triangle";
    }

    @Override
    public String toString(){
        return getTypeOfFigure() + ": a = " + a + " b = " + b + " area = " + getArea();
    }
}
package istu_oop_lab2;

public class Triangle extends Figure {
    Double h;
    Double a;

    public Triangle(Double h, Double a){
        this.a = a;
        this.h = h;
        findArea();
    }

    @Override
    public void findArea() {
        setArea(a * h / 2);
    }

    @Override
    public String getTypeOfFigure() {
        return "Triangle";
    }

    @Override
    public String toString(){
        return getTypeOfFigure() + ": h = " + h + " a = " + a + " area = " + getArea();
    }
}

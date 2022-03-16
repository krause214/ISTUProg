package istu_oop_lab2;

public class Ellipse extends Figure{
    private Double rMin;
    private Double rMax;

    public Ellipse(Double rMin, Double rMax){
        this.rMin = rMin;
        this.rMax = rMax;
        findArea();
    }

    @Override
    public void findArea() {
        setArea(rMin * rMax * Math.PI);
    }

    @Override
    public String getTypeOfFigure() {
        return "Ellipse";
    }

    @Override
    public String toString(){
        return getTypeOfFigure() + ": rMin = " + rMin + " rMax = " + rMax + " area = " + getArea();
    }



}

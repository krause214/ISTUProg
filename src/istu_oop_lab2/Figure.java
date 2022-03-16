package istu_oop_lab2;

public abstract class Figure {
    private Double area;

    public abstract void findArea();

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getArea(){
        return area;
    }

    public abstract String toString();
    public abstract String getTypeOfFigure();
}

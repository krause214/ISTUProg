package istu_oop.lab1;

public class Vehicle {
    private Person driver;
    private CarModel model;
    private String licensePlate;

    public Vehicle() {
    }

    public Vehicle(CarModel model, String licensePlate) {
        this.model = model;
        this.licensePlate = licensePlate;
    }

    public void setDriver(Person person){
        if (person.getAge() < 18){
            System.out.println("The age of person is lower than 18!");
        }
        this.driver = person;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "driver={fName=" + driver.getFName() +
                ", pName=" + driver.getPName() +
                ", sName=" + driver.getSName() +
                "}, model=" + model +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}

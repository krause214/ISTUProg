package istu_oop_java_lab1;

import java.io.IOException;

public class Person {
    private String fName;
    private String sName;
    private String pName;
    private int age;


    public Person() {
    }

    public Person(String fName, String sName, String pName, int age) throws IOException {
        setFName(fName);
        setSName(sName);
        setPName(pName);
        setAge(age);
    }

    public void setAge(int age) throws IOException {
        if (age < 0 || age > 200){
            throw new IOException("Incorrect age");
        }
        this.age = age;
    }

    public void setFName(String fName) throws IOException {
        if (fName.length() > 20){
            throw new IOException("Incorrect fName");
        }
        this.fName = fName;
    }

    public void setSName(String sName) throws IOException {
        if (sName.length() > 20){
            throw new IOException("Incorrect sName");
        }
        this.sName = sName;
    }

    public void setPName(String pName) throws IOException {
        if (pName.length() > 20){
            throw new IOException("Incorrect fName");
        }
        this.pName = pName;
    }

    public String getFName() {
        return fName;
    }

    public String getSName() {
        return sName;
    }

    public String getPName() {
        return pName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fName='" + fName + '\'' +
                ", pName='" + pName + '\'' +
                ", sName='" + sName + '\'' +
                ", age=" + age +
                '}';
    }
}

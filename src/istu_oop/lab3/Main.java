package istu_oop.lab3;


import java.util.Random;

public class Main {
    public static void main(String args[]) throws Exception {
        MyQueue<Integer> queue = new MyQueue(3);
        for(int i = 0; i < 3; i++){
            queue.addElement(i);
        }
        try {
            queue.addElement(new Random().nextInt());
        } catch (Exception e){
            System.out.println(e);
        }

        for(int i = 0; i < 3; i++){
            System.out.println(queue.getElement());
        }
        try {
            System.out.println(queue.getElement());
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
package istu_oop.lab3;


public class Main {
    public static void main(String args[]) throws Exception {
        MyQueue<Integer> queue = new MyQueue(3);
        for(int i = 0; i < 3; i++){
            queue.addElement(i);
        }
        try {
            queue.addElement(5);
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
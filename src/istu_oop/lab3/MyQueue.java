package istu_oop.lab3;

import java.util.ArrayList;

public class MyQueue<E> {
    private final int queueLength;
    private int elsInQueue;
    private final ArrayList<E> elements;

    public MyQueue(int queueLength) {
        this.queueLength = queueLength;
        elsInQueue = 0;
        elements = new ArrayList<>(queueLength);
    }


    public void addElement(E element) throws Exception {
        if (elsInQueue == queueLength){
            throw new Exception("Queue is full!");
        }
        else{
            elements.add(element);
            elsInQueue++;
        }
    }

    public E getElement() throws Exception{
        if (elsInQueue == 0){
            throw new Exception("Queue is empty!");
        }
        else{
            elsInQueue--;
            E element = elements.get(0);
            elements.remove(0);
            return element;
        }
    }

    public int getQueueLength() {
        return queueLength;
    }

    public int getElsInQueue() {
        return elsInQueue;
    }
}
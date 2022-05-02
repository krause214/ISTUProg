package probability_theory.lab3;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        Distribution distribution = new Distribution(200);

        int w = 640;
        int h = 480;
        JFrame frame = new JFrame();
        Histogram dc = new Histogram(w, h, distribution);
        frame.setSize(w, h);
        frame.setTitle("Histogram");
        frame.add(dc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

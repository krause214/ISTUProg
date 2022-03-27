package probability_theory.lab1;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BernoulliDistribution bd = new BernoulliDistribution(0.32, 10);
        bd.addToSegments(100);
        for (int num :
                bd.results) {
            System.out.print(num + " ");
        }
        System.out.println();
        bd.printHistogram();
    }
}

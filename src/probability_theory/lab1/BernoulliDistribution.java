package probability_theory.lab1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class BernoulliDistribution {
    double p;
    double q;
    int n;
    ArrayList <Double> pArr = new ArrayList<>();
    ArrayList <Double> aArr = new ArrayList<>();
    ArrayList <Integer> results = new ArrayList<>();

    public BernoulliDistribution(double p, int n) {
        this.p = p;
        this.q = 1 - p;
        this.n = n;
        pArr.add(0, Math.pow(q, n));
        aArr.add(0, Math.pow(q,n));
        results.add(0, 0);
        for (int i = 1; i < n; i++){
            pArr.add(i, pArr.get(i-1) * p/q * (n-i+1) / i);
            aArr.add(i, aArr.get(i-1) + pArr.get(i));
            results.add(i, 0);
        }
    }

    public void printHistogram(){
        for (int i = 40; i > 0; i--){
            for (int val:
                    results) {
                if (val >= i){
                    System.out.print("| ");
                }
                else System.out.print("  ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++){
            System.out.print(i + " ");
        }
        System.out.println("\n'|' equals 0,01");
    }

    //add n values to intervals, write intervals to file
    public void addToSegments (int n) throws IOException {
        FileWriter fw = new FileWriter("values.txt", false);

        double rand;
        for (int i = 0; i < n; i++){
            rand = ThreadLocalRandom.current().nextDouble();

            if (rand < aArr.get(0)){
                results.set(0, results.get(0) + 1);
                fw.write(0 + " ");
            }
            else {
                for (int j = 1; j < this.n; j++){
                    if (rand > aArr.get(j - 1) && rand < aArr.get(j)){
                        results.set(j, results.get(j) + 1);
                        fw.write(j + " ");
                    }
                }
            }
        }
        fw.write("EOF");
        fw.close();
    }
}

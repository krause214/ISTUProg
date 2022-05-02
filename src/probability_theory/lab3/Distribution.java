package probability_theory.lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Distribution {
    int sigma = 1;
    int m = 5;
    int amountOfIters;
    int N;
    ArrayList<Double> vals = new ArrayList<>();
    double[] intervals;
    double lenInterval;
    double min;
    double max;

    double randSum(){
        double sum = 0;
        Random r = new Random();
        for (int i = 0; i < 12; i++){
            sum += r.nextDouble();
        }
        return (sum - 6);
    }

    Distribution (int amountOfIters){
        this.amountOfIters = amountOfIters;
        N = (int)(Math.log(amountOfIters + 1)/(Math.log(2)));
        intervals = new double[N];
        for (int i = 0; i < amountOfIters; i++){
            vals.add(sigma * randSum() + m);
        }
        Collections.sort(vals);
        min = vals.get(0);
        max = vals.get(amountOfIters - 1);
        lenInterval = (max - min)/N;

        for (int i = 0; i < amountOfIters; i++){
            for (int j = 1; j < intervals.length + 1; j++){
               if (vals.get(i) > (lenInterval * (j - 1)) + min && vals.get(i) < lenInterval * j + min) {
                   intervals[j - 1]++;
                   break;
               }
            }
        }
        for (int i = 0; i < intervals.length; i++){
            intervals[i] = intervals[i]/(amountOfIters * lenInterval);
        }

    }
}
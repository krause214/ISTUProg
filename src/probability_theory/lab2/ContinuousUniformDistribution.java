package probability_theory.lab2;

import java.util.Random;

public class ContinuousUniformDistribution {
    double min;
    double max;
    double[] vals;
    double[] intervals;
    double lenInterval;
    double a;
    double b;

    public ContinuousUniformDistribution(int n, double a, double b){
        this.a = a;
        this.b = b;
        this.min = Double.POSITIVE_INFINITY;
        this.max = Double.NEGATIVE_INFINITY;
        int amountOfInters = (int)(Math.log(n + 1));
        intervals = new double[amountOfInters];
        Random r = new Random();
        vals = new double[n];
        lenInterval = (double)((b - a) / amountOfInters);
        for (int i = 0; i < n; i++){
            vals[i] = r.nextDouble() + (Math.abs(r.nextInt()) % (a - b));
            for (int j = 1; j < intervals.length + 1; j++){
                if (vals[i] > lenInterval * j - 1 && vals[i] < lenInterval * j){
                    intervals[j - 1]++;
                    break;
                }
            }
        }

        for (int i = 0; i < intervals.length; i++){
            intervals[i] = intervals[i]/n;
        }

        for (int i = 0; i < n; i++){
            if (min > a + vals[i]){
                min = a + vals[i];
            }
            if (max < a + vals[i]){
                max = a + vals[i];
            }
        }
        lenInterval = (double)((max - min) / amountOfInters);
    }
}

package probability_theory.lab2;

import java.util.Random;

public class ContinuousUniformDistribution {
    double min;
    double max;
    double[] vals;
    int[] intervals;
    double lenInterval;

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public ContinuousUniformDistribution(int n){
        int amountOfInters = (int)(Math.log(n + 1)) + 5;
        intervals = new int[amountOfInters];
        min = Double.POSITIVE_INFINITY;
        max = Double.NEGATIVE_INFINITY;
        Random r = new Random();
        vals = new double[n];
        for (int i = 0; i < n; i++){
            vals[i] = r.nextDouble();
            if (vals[i] > max){
                max = vals[i];
            }
            if (vals[i] < min){
                min = vals[i];
            }
        }

        lenInterval = (max - min) / amountOfInters;
        for (int i = 0; i < n; i++){
            vals[i] = distributionFunction(vals[i]);
            for (int j = 1; j < intervals.length + 1; j++){
                if (vals[i] > min + lenInterval * j - 1 && vals[i] < min + lenInterval * j){
                    intervals[j - 1]++;
                    break;
                }
            }
        }
    }
    public Double distributionFunction(double x){
        return (x - min) / (max - min);
    }
}

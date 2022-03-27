package istu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] res = new long[n + 1];
        res[0] = 1;
        for (int i = 1; i < n + 1; i++){
            for (int j = n; j >= i; j--){
                res[j] = res[j] + res[j-i];
            }
            if (i == n){
                System.out.print(res[n] % 1000000000);
            } else {
                System.out.print(res[n] % 1000000000 + " ");
            }
        }
    }
}
/*
10
*/
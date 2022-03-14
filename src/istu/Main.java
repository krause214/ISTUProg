package istu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] matrix = new int[10][10];
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                matrix[i][j] = in.nextInt();
            }
        }


    }
}
/*

String.format("%.3f", d )

3
1 2 3
0 4 7
0 0 3
10 20 6

*/
package istu;

import java.util.ArrayList;
import java.util.Scanner;

class Bead {
    static int len;
    static int initPos = 0;
    static ArrayList<Character> bead = new ArrayList<>();

    static void del() {
        bead.remove((initPos + 1) % len);
        len -= 1;
    }

    static void add(Character c) {
        len += 1;
        bead.add((initPos + 1) % len, c);
    }

    static void move() {
        initPos = (initPos + 1) % len;
    }
}
class my
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Bead.len = in.nextInt();
        in.nextLine();
        String temp;
        temp = in.nextLine();
        for (int i = 0; i < temp.length(); i++) {
            Bead.bead.add(temp.charAt(i));
        }
        while (in.hasNext()) {
            temp = in.nextLine();
            if (temp.charAt(0) == 'D') {
                Bead.del();
            } else if (temp.charAt(0) == 'M') {
                Bead.move();
            } else if (temp.charAt(0) == 'I') {
                Bead.add(temp.charAt(2));
            } else {
                break;
            }
        }
        for (int i = 0; i < Bead.len; i++) {
            System.out.print(Bead.bead.get((i + Bead.initPos) % Bead.len));
        }

    }
}

/*
4
DrIq
D
M
I S
M
D
D
I S
M
E
 */

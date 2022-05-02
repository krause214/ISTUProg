package istu;

import java.util.ArrayList;
import java.util.Collections;
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
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        int n = in.nextInt();
        in.nextLine();
        arrayList.add(new ArrayList<>(Collections.nCopies(n,0)));
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int counter = 0;
        int wordLen;
        String[] strArray = in.nextLine().split(" ");
        for (String word :
                strArray) {
            counter += word.length();
            if (word.charAt(word.length() - 1) == '.'
                || word.charAt(word.length() - 1) == '!'
                || word.charAt(word.length() - 1) == '?'){
                wordLen = word.length() + 2;
                counter += 2;
            }else {
                wordLen = word.length() + 1;
                counter++;
            }

            if (counter > n){
                for (int j = counter - wordLen - 1; j < n; j++){
                    arrayList.get(i).set(j, 1);
                }
                arrayList.add(new ArrayList<>(Collections.nCopies(n,0)));
                i++;
                if (word.charAt(word.length() - 1) == '.'){
                    counter = word.length() + 2;
                    arrayList.get(i).set(counter - 1, 1);
                    arrayList.get(i).set(counter - 2, 1);
                }else {
                    counter = word.length() + 1;
                    arrayList.get(i).set(counter - 1, 1);
                }
            }else {
                if (word.charAt(word.length() - 1) == '.'
                        || word.charAt(word.length() - 1) == '!'
                        || word.charAt(word.length() - 1) == '?'){
                    arrayList.get(i).set(counter - 1, 1);
                    arrayList.get(i).set(counter - 2, 1);
                }else {
                    arrayList.get(i).set(counter - 1, 1);
                }
            }
        }
/*        for (ArrayList<Integer> arr:
                arrayList) {
            System.out.println(arr.toString());
        }*/
        ArrayList<Integer> resArr = new ArrayList<>(n);
        for (int j = 0; j < n; j++){
            resArr.add(j + 1);
        }
        for (i = 0; i < arrayList.size(); i++){
            for (int j = 0; j < n; j++){
                if (arrayList.get(i).get(j) == 0) resArr.set(j,0);
            }
        }


        counter = 0;
        boolean fl = false;
        for (i = 0; i < n; i++){
            if (resArr.get(i) > 0){
                counter++;
            }
        }
        if (counter > 0){
            System.out.println(counter);
            for (Integer integer :
                    resArr) {
                if (integer > 0){
                    if (fl){
                        System.out.print(" " + integer);
                    }
                    System.out.print(integer);
                    fl = true;
                }
            }
        }
        else {
            System.out.println(0);
        }
    }
}

/*
6
Run Mozilla Firefox
Run Free Pascal
Alt+Tab
Run Miranda IM
Alt+Tab+Tab
Alt+Tab+Tab+Tab

10
Hello you all. From ISTU.

 */
//package sorting;
package com.kabir.milton;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> ar = new ArrayList<>();
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            // write your code here
            ar.add(number);
        }
        Collections.sort(ar);
        int sz = ar.size();
        System.out.println("Total numbers: " + sz + ".");
        Long mx = ar.get(sz - 1);
        int cnt = 0;
        for (int i = sz - 1; i >= 0; i--) {
            if (ar.get(i) < mx) {
                break;
            } else {
                cnt++;
            }
        }
        System.out.println("The greatest number: " + mx + " (" + cnt + " time(s)).");
    }
}
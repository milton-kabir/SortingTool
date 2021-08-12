//package sorting;
package com.kabir.milton;

import java.util.*;

public class Main {
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void main(final String[] args) {
        String st = "word";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-dataType")) {
                st = args[i + 1];
            }
        }
        if (st.equals("long")) {
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
            int pp = 100 * cnt / sz;

            System.out.println("The greatest number: " + mx + " (" + cnt + " time(s), " + pp + "%).");

        } else if (st.equals("word")) {
            Scanner scanner = new Scanner(System.in);
            HashMap<String, Integer> hm = new HashMap<>();
            HashMap<String, Integer> myMap = new HashMap<>();
            int sz = 0;
            while (scanner.hasNextLine()) {
                String[] number = scanner.nextLine().split("\\s+");
                // write your code here
                sz += number.length;
                for (int i = 0; i < number.length; i++) {
                    if (myMap.containsKey(number[i])) {
                        int xx = myMap.get(number[i]);
                        xx++;
                        myMap.put(number[i], xx);
                    } else {
                        myMap.put(number[i], 1);
                    }
                    hm.put(number[i], number[i].length());
                }
            }
            Map<String, Integer> hm1 = sortByValue(hm);
            System.out.println("Total words: " + sz + ".");
            String mx = "";
            for (Map.Entry<String, Integer> en : hm1.entrySet()) {
                mx = en.getKey();
            }
            int cnt = myMap.get(mx);
            int pp = 100 * cnt / sz;
            System.out.println("The longest word: " + mx + " (" + cnt + " time(s), " + pp + "%).");

        } else {
            Scanner scanner = new Scanner(System.in);
            HashMap<String, Integer> hm = new HashMap<>();
            HashMap<String, Integer> myMap = new HashMap<>();
            int sz = 0;
            while (scanner.hasNextLine()) {
                String number = scanner.nextLine();
                // write your code here
                if (myMap.containsKey(number)) {
                    int xx = myMap.get(number);
                    xx++;
                    myMap.put(number, xx);
                } else {
                    myMap.put(number, 1);
                }
                hm.put(number, number.length());
                sz++;
            }
            Map<String, Integer> hm1 = sortByValue(hm);
            System.out.println("Total words: " + sz + ".");
            String mx = "";
            for (Map.Entry<String, Integer> en : hm1.entrySet()) {
                mx = en.getKey();
            }
            int cnt = myMap.get(mx);
            int pp = 100 * cnt / sz;
            System.out.println("The longest line:\n" +
                    mx + "\n" +
                    "(" + cnt + " time(s), " + pp + "%).");
        }

    }
}
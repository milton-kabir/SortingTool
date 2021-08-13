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
        String tt = "natural";
        int ck = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("java") || args[i].equals("SortingTool")) {
                continue;
            }
            if (args[i].equals("-dataType")) {
                if (i + 1 == args.length) {
                    System.out.println("No data type defined!");
                    return;
                }
                st = args[i + 1];
                if (!st.equals("long") && !st.equals("word") && !st.equals("line")) {
                    System.out.println("No data type defined!");
                    return;
                }
                i++;

            } else if (args[i].equals("-sortingType")) {
                if (i + 1 == args.length) {
                    System.out.println("No sorting type defined!");
                    return;
                }
                tt = args[i + 1];
                if (!tt.equals("byCount") && !tt.equals("natural")) {
                    System.out.println("No sorting type defined!");
                    return;
                }
                i++;
            } else {
                System.out.println("\"" + args[i] + "\" is not a valid parameter. It will be skipped.");
            }

        }
        if (st.equals("long")) {
            Scanner scanner = new Scanner(System.in);
            Set<Long> ar = new HashSet<>();
            HashMap<String, Integer> hm = new HashMap<>();
            int sz = 0;
            while (scanner.hasNextLong()) {
                long number = scanner.nextLong();
                sz++;
                // write your code here
                ar.add(number);
                if (hm.containsKey(Long.toString(number))) {
                    int xx = hm.get(Long.toString(number));
                    xx++;
                    hm.put(Long.toString(number), xx);
                } else {
                    hm.put(Long.toString(number), 1);
                }
            }
            List<Long> list = new ArrayList<Long>(ar);
            Collections.sort(list);

            System.out.println("Total numbers: " + sz + ".");
            if (tt.equals("natural")) {
                System.out.print("Sorted data:");
                for (Long ii : list) {
                    for (int j = 0; j < hm.get(Long.toString(ii)); j++)
                        System.out.print(" " + ii);
                }

            } else {

                Map<String, Integer> hm1 = sortByValue(hm);
                for (String ii : hm1.keySet()) {
                    int pq = 100 * hm1.get(ii) / sz;
                    String ts = ii;
                    int xx = hm1.get(ii);
                    List<Long> mm = new ArrayList<>();
                    for (int jj = 0; jj < list.size(); jj++) {
                        String sss = Long.toString(list.get(jj));
                        if (hm.get(sss) == xx) {
                            mm.add(list.get(jj));
                        }
                    }
                    for (int i = 0; i < mm.size(); i++) {
                        System.out.println(mm.get(i) + ": " + xx + " time(s), " + pq + "%");
                        list.remove(mm.get(i));
                    }

                }

            }
        } else if (st.equals("word")) {
            Scanner scanner = new Scanner(System.in);
            HashMap<String, Integer> hm = new HashMap<>();
            HashMap<String, Integer> myMap = new HashMap<>();
            ArrayList<String> ss = new ArrayList<>();
            int sz = 0;
            while (scanner.hasNextLine()) {
                String[] number = scanner.nextLine().split("\\s+");
                // write your code here
                sz += number.length;
                for (int i = 0; i < number.length; i++) {
                    ss.add(number[i]);
                    if (myMap.containsKey(number[i])) {
                        int xx = myMap.get(number[i]);
                        xx++;
                        myMap.put(number[i], xx);
                    } else {
                        myMap.put(number[i], 1);
                    }
                }
            }
            Map<String, Integer> hm1 = sortByValue(myMap);
            Collections.sort(ss);
            Set<String> ar = new HashSet<>();
            ar.addAll(ss);

            System.out.println("Total words: " + sz + ".");
            if (tt.equals("natural")) {
                System.out.print("Sorted data:");
                for (int i = 0; i < ss.size(); i++) {
                    System.out.print(" " + ss.get(i));
                }

            } else {
                for (String ii : hm1.keySet()) {
                    int pq = 100 * hm1.get(ii) / sz;
                    String ts = ii;
                    int xx = hm1.get(ii);
                    List<String> mm = new ArrayList<>();
                    for (String jj : ar) {
                        String sss = jj;
                        //System.out.println(sss);
                        if (hm1.get(sss) == xx) {
                            mm.add(jj);
                        }
                    }
                    Collections.sort(mm);
                    for (int i = 0; i < mm.size(); i++) {
                        System.out.println(mm.get(i) + ": " + xx + " time(s), " + pq + "%");
                        ar.remove(mm.get(i));
                    }

                }

            }

        } else {
            Scanner scanner = new Scanner(System.in);
            HashMap<String, Integer> myMap = new HashMap<>();
            ArrayList<String> ss = new ArrayList<>();
            int sz = 0;
            while (scanner.hasNextLine()) {
                String number = scanner.nextLine();
                // write your code here
                ss.add(number);
                if (myMap.containsKey(number)) {
                    int xx = myMap.get(number);
                    xx++;
                    myMap.put(number, xx);
                } else {
                    myMap.put(number, 1);
                }
                sz++;
            }
            Map<String, Integer> hm1 = sortByValue(myMap);
            Collections.sort(ss);
            Set<String> ar = new HashSet<>();
            ar.addAll(ss);
            System.out.println("Total words: " + sz + ".");
            if (tt.equals("natural")) {

                System.out.print("Sorted data:");
                for (int i = 0; i < ss.size(); i++) {
                    System.out.print(" " + ss.get(i));
                }

            } else {

                for (String ii : hm1.keySet()) {
                    int pq = 100 * hm1.get(ii) / sz;
                    String ts = ii;
                    int xx = hm1.get(ii);
                    List<String> mm = new ArrayList<>();
                    for (String jj : ar) {
                        String sss = jj;
                        //System.out.println(sss);
                        if (hm1.get(sss) == xx) {
                            mm.add(jj);
                        }
                    }
                    Collections.sort(mm);
                    for (int i = 0; i < mm.size(); i++) {
                        System.out.println(mm.get(i) + ": " + xx + " time(s), " + pq + "%");
                        ar.remove(mm.get(i));
                    }

                }


            }

        }
    }
}
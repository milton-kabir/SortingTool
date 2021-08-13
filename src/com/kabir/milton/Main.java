//package sorting;
package com.kabir.milton;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        var list = new LinkedList<>(hm.entrySet());
        list.sort(Map.Entry.comparingByValue());
        var temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void main(final String[] args) throws IOException {
        String st = "word";
        String tt = "natural";
        String ww = "write";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-outputFile")) {
                ww = args[i + 1];
            }
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("java") || args[i].equals("SortingTool")) {
                continue;
            }
            if (args[i].equals("-dataType")) {
                if (i + 1 == args.length) {
                    if (!ww.equals("write")) {
                        var myWriter = new FileWriter(ww);
                        myWriter.write("No data type defined!");
                        myWriter.close();
                    } else {
                        System.out.println("No data type defined!");
                    }
                    return;
                }
                st = args[i + 1];
                if (!st.equals("long") && !st.equals("word") && !st.equals("line")) {
                    if (!ww.equals("write")) {
                        var myWriter = new FileWriter(ww);
                        myWriter.write("No data type defined!");
                        myWriter.close();
                    } else {
                        System.out.println("No data type defined!");
                    }
                    return;
                }
                i++;
            } else if (args[i].equals("-sortingType")) {
                if (i + 1 == args.length) {
                    if (!ww.equals("write")) {
                        var myWriter = new FileWriter(ww);
                        myWriter.write("No sorting type defined!");
                        myWriter.close();

                    } else {
                        System.out.println("No sorting type defined!");
                    }
                    return;
                }
                tt = args[i + 1];
                if (!tt.equals("byCount") && !tt.equals("natural")) {
                    if (!ww.equals("write")) {
                        var myWriter = new FileWriter(ww);
                        myWriter.write("No sorting type defined!");
                        myWriter.close();

                    } else {
                        System.out.println("No sorting type defined!");
                    }
                    return;
                }
                i++;
            } else {
                if (!ww.equals("write")) {
                    var myWriter = new FileWriter(ww);
                    myWriter.write("\"" + args[i] + "\" is not a valid parameter. It will be skipped.");
                    myWriter.close();
                } else {
                    System.out.println("\"" + args[i] + "\" is not a valid parameter. It will be skipped.");
                }
            }

        }
        if (st.equals("long")) {
            var scanner = new Scanner(System.in);
            var ar = new HashSet<Long>();
            var hm = new HashMap<String, Integer>();
            int sz = 0;
            while (scanner.hasNextLong()) {
                long number = scanner.nextLong();
                sz++;
                ar.add(number);
                if (hm.containsKey(Long.toString(number))) {
                    int xx = hm.get(Long.toString(number));
                    xx++;
                    hm.put(Long.toString(number), xx);
                } else {
                    hm.put(Long.toString(number), 1);
                }
            }
            var list = new ArrayList<>(ar);
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
                    int xx = hm1.get(ii);
                    var mm = new ArrayList<Long>();
                    for (Long aLong : list) {
                        String sss = Long.toString(aLong);
                        if (hm.get(sss) == xx) {
                            mm.add(aLong);
                        }
                    }
                    for (Long aLong : mm) {
                        System.out.println(aLong + ": " + xx + " time(s), " + pq + "%");
                        list.remove(aLong);
                    }

                }

            }
        } else if (st.equals("word")) {
            var scanner = new Scanner(System.in);
            var myMap = new HashMap<String, Integer>();
            var ss = new ArrayList<String>();
            int sz = 0;
            while (scanner.hasNextLine()) {
                String[] number = scanner.nextLine().split("\\s+");
                sz += number.length;
                for (String s : number) {
                    ss.add(s);
                    if (myMap.containsKey(s)) {
                        int xx = myMap.get(s);
                        xx++;
                        myMap.put(s, xx);
                    } else {
                        myMap.put(s, 1);
                    }
                }
            }
            myFun(tt, myMap, ss, sz);

        } else {
            var scanner = new Scanner(System.in);
            var myMap = new HashMap<String, Integer>();
            var ss = new ArrayList<String>();
            int sz = 0;
            while (scanner.hasNextLine()) {
                String number = scanner.nextLine();
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
            myFun(tt, myMap, ss, sz);
        }
    }
    private static void myFun(String tt, HashMap<String, Integer> myMap, ArrayList<String> ss, int sz) {
        Map<String, Integer> hm1 = sortByValue(myMap);
        Collections.sort(ss);
        var ar = new HashSet<>(ss);
        System.out.println("Total words: " + sz + ".");
        if (tt.equals("natural")) {
            System.out.print("Sorted data:");
            for (String s : ss) {
                System.out.print(" " + s);
            }
        } else {
            for (String ii : hm1.keySet()) {
                int pq = 100 * hm1.get(ii) / sz;
                int xx = hm1.get(ii);
                var mm = new ArrayList<String>();
                for (String jj : ar) {
                    if (hm1.get(jj) == xx) {
                        mm.add(jj);
                    }
                }
                Collections.sort(mm);
                for (String s : mm) {
                    System.out.println(s + ": " + xx + " time(s), " + pq + "%");
                    ar.remove(s);
                }
            }
        }
    }
}
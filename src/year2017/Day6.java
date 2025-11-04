package year2017;

import java.util.*;

public class Day6 {
    public static void main(String[] args) {
        String input = "2\t8\t8\t5\t4\t2\t3\t1\t5\t5\t1\t2\t15\t13\t5\t14";
        Scanner sc = new Scanner(input).useDelimiter("\t");
        ArrayList<Integer> array = new ArrayList<>();
        while (sc.hasNext()) {
            array.add(sc.nextInt());
        }
        System.out.println("Solución 1: " + part1(array));
        System.out.println("Solución 2: " + part2(array));
    }

    private static int part1(ArrayList<Integer> input) {
//        input = new ArrayList<>(List.of(0,2,7,0));
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(input);
        int max, index, sol = 0;
        do {
            ArrayList<Integer> temp = (ArrayList<Integer>) list.getLast().clone();
            max = Collections.max(temp);
            index = temp.indexOf(max);
            temp.set(index, 0);
            for (int i = 0; i < max; i++) {
                index = (index + 1) % input.size();
                temp.set(index, temp.get(index) + 1);
            }
            sol++;
            for (ArrayList<Integer> l : list) {
                if (l.equals(temp)) {
                    return sol;
                }
            }
            list.add(temp);
        } while (true);
    }

    private static int part2(ArrayList<Integer> input) {
//        input = new ArrayList<>(List.of(0, 2, 7, 0));
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(input);
        int max, index;
        do {
            ArrayList<Integer> temp = (ArrayList<Integer>) list.getLast().clone();
            max = Collections.max(temp);
            index = temp.indexOf(max);
            temp.set(index, 0);
            for (int i = 0; i < max; i++) {
                index = (index + 1) % input.size();
                temp.set(index, temp.get(index) + 1);
            }
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).equals(temp))
                    return list.size() - i;
            list.add(temp);
        } while (true);
    }

}

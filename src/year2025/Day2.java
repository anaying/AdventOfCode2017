package year2025;

import java.util.Scanner;

public class Day2 {
    private static final String input = "19391-47353,9354357-9434558,4646427538-4646497433,273-830,612658-674925,6639011-6699773,4426384-4463095,527495356-527575097,22323258-22422396,412175-431622,492524-611114,77-122,992964846-993029776,165081-338962,925961-994113,7967153617-7967231799,71518058-71542434,64164836-64292066,4495586-4655083,2-17,432139-454960,4645-14066,6073872-6232058,9999984021-10000017929,704216-909374,48425929-48543963,52767-94156,26-76,1252-3919,123-228";
    private static final String tester = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124";

    private static long part1() {
        long sol = 0;
        Scanner sc = new Scanner(input).useDelimiter(",");
        while (sc.hasNext()) {
            String[] range = sc.next().split("-");
            for (long i = Long.parseLong(range[0]); i <= Long.parseLong(range[1]); i++) {
                long separator = (long) Math.pow(10, String.valueOf(i).length() / 2);
                if (i % separator == i / separator) {
                    sol += i;
                }
            }
        }
        return sol;
    }

    private static long part2() {
        long sol = 0;
        Scanner sc = new Scanner(input).useDelimiter(",");
        while (sc.hasNext()) {
            String[] range = sc.next().split("-");
            for (long i = Long.parseLong(range[0]); i <= Long.parseLong(range[1]); i++) {
                String str = String.valueOf(i);
                int strLength = str.length();
                for (int denominator = 1; denominator <= strLength / 2; denominator++) {
                    if (strLength % denominator == 0) {
                        boolean symmetry = true;
                        String pattern = str.substring(0, denominator);
                        for (int n = denominator; n < strLength; n += denominator) {
                            if (!pattern.equals(str.substring(n, n + denominator))) {
                                symmetry = false;
                                break;
                            }
                        }
                        if (symmetry) {
                            sol += i;
                            break;
                        }
                    }
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        System.out.println("Solución 1: " + part1());
        System.out.println("Solución 2: " + part2());
    }
}

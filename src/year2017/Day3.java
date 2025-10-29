package year2017;

import java.util.ArrayList;
import java.util.List;

public class Day3 {
    public static void main(String[] args) {
        int input = 361527;
        System.out.println("Solución 1: " + part1(input));
        System.out.println("Solución 2: " + part2(input));
    }

    private static int part1(int input) {
        int lado = -1;
        while (lado * lado < input) {
            lado += 2;
        }
/*
        int[] coordinates = new int[]{lado / 2, -lado / 2};
        for (int i=lado*lado; i>input; i--){
            if(coordinates[1]==-lado/2 && coordinates[0]>-lado/2)
                coordinates[0]--;
            else if (coordinates[0]==-lado/2 && coordinates[1]<lado/2)
                coordinates[1]++;
            else if (coordinates[1]==lado/2 && coordinates[0]<lado/2)
                coordinates[0]++;
            else
                coordinates[1]--;
        }
        return Math.abs(coordinates[0]) + Math.abs(coordinates[1]);
*/

//        int max = lado - 1;
        int min = lado / 2;
        int d = (lado * lado - input) % (lado - 1); //d: distancia del input a la esquina siguiente (sentido antihorario)
        return min + (Math.abs(d - min));
    }

    private static int part2(int input) {
        ArrayList<ArrayList<Integer>> spiral = new ArrayList<>();
        spiral.add(new ArrayList<>());
        spiral.getFirst().addAll(List.of(new Integer[]{1, 2, 4, 5, 10, 11, 23, 25}));
        int longitud, lado, posicion, num = 0, dif;
        do {
            ArrayList<Integer> anillo = spiral.getLast();
            spiral.add(new ArrayList<>());
            longitud = spiral.size() * 2;
            for (int i = 0; i < longitud * 4; i++) {
                lado = i / longitud;
                posicion = i % longitud;
                if (spiral.getLast().isEmpty())
                    num = anillo.getLast() + anillo.getFirst();
                else {
                    num = spiral.getLast().getLast();
                    dif = lado * 2 + 1;
                    if (posicion == longitud - 1) {
                        num += anillo.get(i - dif - 1);
                        if (i == longitud * 4 - 1)
                            num += spiral.getLast().getFirst();
                    } else {
                        num += anillo.get(i - dif);
                        if (posicion == 0) {
                            num += spiral.getLast().get(i - 2);
                            num += anillo.get(i - dif + 1);
                        } else if (posicion == longitud - 2) {
                            num += anillo.get(i - dif - 1);
                            if (i == longitud * 4 - 2)
                                num += spiral.getLast().getFirst();
                        } else if (i != 1)
                            num += anillo.get(i - dif - 1) + anillo.get(i - dif + 1);
                        else
                            num += anillo.get(i - dif + 1) + anillo.getLast();
                    }
                }
                spiral.getLast().add(num);
                if (num > input)
                    break;
            }
        } while (num <= input);
        return num;
    }
}

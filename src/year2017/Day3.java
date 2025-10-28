package year2017;

public class Day3 {
    public static void main(String[] args) {
        int input = 361527;
        System.out.println("Solución 1: " + part1(input));
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
        int d = (lado * lado - input) % (lado - 1); //d: distancia desde el input a la esquina siguiente (sentido antihorario)
        return min + (Math.abs(d - min));
    }
}

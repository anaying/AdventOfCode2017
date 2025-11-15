package year2017;

import java.util.Arrays;

public class Day10 {
    static String input = "197,97,204,108,1,29,5,71,0,50,2,255,248,78,254,63";

    public static void main(String[] args) {
        System.out.println("Solución 1: " + part1());
        System.out.println("Solución 2: " + part2());
    }

    private static int part1() {
        short size = 256;
        short[] list = new short[size];
        short skip = 0, position = 0, length;
        for (short i = 0; i < list.length; i++)
            list[i] = i;
        for (String s : input.split(",")) {
            length = Short.parseShort(s);
            for (int i = 0, j = length - 1; i < length / 2; i++, j--) {
                short aux = list[(i + position) % size];
                list[(i + position) % size] = list[(j + position) % size];
                list[(j + position) % size] = aux;
            }
            position += (short) ((length + skip++) % size);
        }
        return list[0] * list[1];
    }

    private static String part2() {
        short size = 256;
        int[] sparseHash = new int[size];
        for (int i = 0; i < sparseHash.length; i++)
            sparseHash[i] = i;

        byte[] bytes = input.getBytes();
        byte[] concat = {17, 31, 73, 47, 23}, sequence = new byte[bytes.length + concat.length];
        System.arraycopy(bytes, 0, sequence, 0, bytes.length);
        System.arraycopy(concat, 0, sequence, bytes.length, concat.length);
        int skip = 0, position = 0;
        for (int round = 1; round <= 64; round++) {
            for (byte length : sequence) {
                for (int i = 0, j = length - 1; i < length / 2; i++, j--) {
                    int aux = sparseHash[(i + position) % size];
                    sparseHash[(i + position) % size] = sparseHash[(j + position) % size];
                    sparseHash[(j + position) % size] = aux;
                }
                position += ((length + skip++) % size);
            }
        }

        int[] denseHash = new int[size / 16];
        for (int i = 0; i < denseHash.length; i++) {
            int xor = sparseHash[i * 16];
            for (int j = 1; j < 16; j++) {
                xor ^= sparseHash[i * 16 + j];
            }
            denseHash[i] = xor;
        }
        StringBuilder result = new StringBuilder();
        Arrays.stream(denseHash).forEach(x -> result.append(String.format("%02x", x)));
        return result.toString();
    }
}

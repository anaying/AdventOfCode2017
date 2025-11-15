package year2017;

public class Day10 {
    static String[] input = "197,97,204,108,1,29,5,71,0,50,2,255,248,78,254,63".split(",");

    public static void main(String[] args) {
        short size = 256;
        short[] list = new short[size];
        short skip = 0, position = 0, length;
        for (short i = 0; i < list.length; i++)
            list[i] = i;
        for (String s : input) {
            length = Short.parseShort(s);
            for (int i = 0, j = length - 1; i < length / 2; i++, j--) {
                short aux = list[(i + position) % size];
                list[(i + position) % size] = list[(j + position) % size];
                list[(j + position) % size] = aux;
            }
            position += (short) ((length + skip++) % size);
        }
        System.out.println("Solución 1: " + list[0] * list[1]);
    }
}

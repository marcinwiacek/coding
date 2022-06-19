import java.io.FileNotFoundException;

public class Main73 {
    //https://practice.geeksforgeeks.org/problems/binary-number-to-decimal-number3525/1
    public static void main(String[] args) throws FileNotFoundException {
        String s = "10001000";
        int p = 1, w = 0;

        long aaaaaa = System.nanoTime();
        for (int i = s.length() - 1; i >= 0; i--) {
            w += (s.charAt(i) - '0') * p;
            p = p << 1;
            System.out.println(w + " " + s.charAt(i));
        }
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

      /*  for (int i=0;i<10;i++) {
            System.out.println(1<<i);
        }*/

        aaaaaa = System.nanoTime();
        w = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            w += (s.charAt(i) - '0') << (s.length() - 1 - i);
            System.out.println(w + " " + s.charAt(i));
        }
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        w = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') w += 1 << (s.length() - 1 - i);
            System.out.println(w + " " + s.charAt(i));
        }
        System.out.println("nano" + (System.nanoTime() - aaaaaa));
    }
}
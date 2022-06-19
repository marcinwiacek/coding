import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;

public class Main63 {

    // find elements from a and b (one from a, one from b), which give target
    public static void main(String[] args) throws FileNotFoundException {
        int[] a = {7, 4, 1, 10};
        int[] b = {4, 5, 8, 3};
        int target = 13;

        long aaaaaa = System.nanoTime();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] + b[j] == target) System.out.println(a[i] + " " + b[j]);
            }
        }
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        HashSet<Integer> h = new HashSet<>(b.length, 1);
        for (int j = 0; j < b.length; j++) {
            h.add(b[j]);
        }
        for (int i = 0; i < a.length; i++) {
            if (h.contains(target - a[i])) System.out.println(a[i] + " " + (target - a[i]));
        }
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        h = new HashSet<>(b.length, 1);
        for (int j = 0; j < b.length; j++) {
            h.add(target - b[j]);
        }
        for (int i = 0; i < a.length; i++) {
            if (h.contains(a[i])) System.out.println(a[i] + " " + (target - a[i]));
        }
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        h = new HashSet<>(b.length, 1);
        for (int i : b) {
            h.add(target - i);
        }
        for (int i : a) {
            if (h.contains(i)) System.out.println(i + " " + (target - i));
        }
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int x = a[i] + b[j];
                if (x > 13) break;
                if (x == target) {
                    System.out.println(a[i] + " " + b[j]);
                    break;
                }
            }
        }
        System.out.println("nano" + (System.nanoTime() - aaaaaa));
    }

}
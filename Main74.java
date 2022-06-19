import java.io.FileNotFoundException;

public class Main74 {

    //https://practice.geeksforgeeks.org/problems/gcd-of-array0614/1
    //https://en.wikipedia.org/wiki/Greatest_common_divisor
    public static int GCD(int a, int b) {
        System.out.println(a + " " + b);
        if (b == 0) return a;
        return GCD(b, b % a);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(GCD(2, GCD(4, 6)));
    }
}
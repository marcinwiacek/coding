import java.io.FileNotFoundException;

public class Main72 {
    //https://practice.geeksforgeeks.org/problems/sum-of-subarrays2229/1/?page=1&category[]=modular%20arithmetic&sortBy=submissions
    public static long subarraySum(long[] a, long n) {
        long result = 0;

        for (int i = 0; i < n; i++)
            result += (a[i] * (i + 1) * (n - i)) % 1000000007;

        return result % 1000000007;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int N = 3;
        long[] A = {1, 2, 3};
        System.out.println(subarraySum(A, N));
    }
}
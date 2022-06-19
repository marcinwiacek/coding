import java.util.HashSet;

public class Main94 {

    //https://practice.geeksforgeeks.org/problems/check-if-two-arrays-are-equal-or-not3847/1
    public static void main(String[] args) {

        int N = 5;
        int[] A = {1, 2, 5, 4, 0};
        int[] B = {2, 4, 5, 0, 1};
        HashSet<Integer> a = new HashSet<>(A.length, 1);
        HashSet<Integer> b = new HashSet<>(B.length, 1);
        for (int i = 0; i < N; i++) {
            a.add(A[i]);
            b.add(B[i]);

        }
        System.out.println(a.hashCode() == b.hashCode());
    }
}
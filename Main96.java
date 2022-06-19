import java.util.Arrays;
import java.util.HashSet;

public class Main96 {

    // https://practice.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x5808/1
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 7};
        int[] b = {5, 6, 3, 4, 8};
        int x = 9;
        Arrays.sort(a);
        HashSet<Integer> bb = new HashSet<>();
        for (int i : b) {
            bb.add(i);
        }
        int j;
        for (int i : a) {
            j = x - i;
            if (bb.contains(j)) {
                bb.remove(j);
                System.out.println(i + " " + j);
            }
        }
    }
}
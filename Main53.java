import java.util.Arrays;
import java.util.HashMap;

public class Main53 {

    //https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    static int CeilIndex(int[] A, int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    //https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    static int LongestIncreasingSubsequenceLength(int[] A, int size) {
        // Add boundary case, when array size is one

        int[] tailTable = new int[size];
        int len; // always points empty slot

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] < tailTable[0]) {
                tailTable[0] = A[i];// new smallest value
            } else if (A[i] > tailTable[len - 1]) {
                tailTable[len++] = A[i]; // A[i] wants to extend largest subsequence
            } else {
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
            }
        }

        for (int i : tailTable) {
            System.out.print(i + " ");
        }
        System.out.println();
        return len;
    }

    //https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    //https://en.wikipedia.org/wiki/Longest_increasing_subsequence
    //https://stackoverflow.com/questions/2631726/how-to-determine-the-longest-increasing-subsequence-using-dynamic-programming
    public static void main(String[] args) {
        int[] x = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        // int[] x = {0, 8, 4, 12};
        //int[] x = {1, 2, 3, 4, 5};

        // we assume, we can sort these things?
        long aaaaaa = System.nanoTime();
        for (int p = 0; p < 1; p++) {
            int n = x.length;
            System.out.println("Length of Longest Increasing Subsequence is " + LongestIncreasingSubsequenceLength(x, n));
        }
        System.out.println("nano " + (System.nanoTime() - aaaaaa));

        //if not...
        long bbbbbb = System.nanoTime();
        for (int p = 0; p < 1; p++) {
            HashMap<Integer, int[]> l = new HashMap<>(x.length, 1);
            l.put(1, new int[]{x[0]});
            int longest = 1;
            for (int i = 1; i < x.length; i++) {
                int j = 1;
                while (j <= longest) {
                    if (l.get(j)[j - 1] > x[i]) break;
                 /*   System.out.print("[");
                    for (int index = 0; index < j; index++) {
                        System.out.print(l.get(j)[index] + " ");
                    }
                    System.out.println("]");*/
                    if (l.get(j)[j - 1] < x[i] && (l.get(j + 1) == null || (l.get(j + 1) != null && l.get(j + 1)[j] > x[i]))) {
                        int[] lll = Arrays.copyOf(l.get(j), j + 1);
                        lll[j] = x[i];
                        l.put(j + 1, lll);
                        if (j + 1 > longest) longest = j + 1;
                        j++;
                        continue;
                    }
                    j++;
                }
            }
            System.out.print("[");
            for (int index = 0; index < longest; index++) {
                System.out.print(l.get(longest)[index] + " ");
            }
            System.out.println("]");
        }
        System.out.println("nano " + (System.nanoTime() - bbbbbb));
        //System.out.format("O(n Log n) %SLog(base2)%S is %S", x.length, x.length, x.length * Math.ceil(Math.log(x.length) / Math.log(2)));
    }

}
import java.util.HashMap;

public class Main95 {

    //https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
    public static void main(String[] args) {
        int N = 7;
        int K = 4;
        int[] A = {1, 2, 1, 3, 4, 2, 3};
        HashMap<Integer, Integer> ile = new HashMap<Integer, Integer>();
        for (int i = 0; i < K; i++) {
            ile.put(A[i], ile.getOrDefault(A[i], 0) + 1);
            System.out.println("blaaaaaa " + ile.get(A[i]));
        }
        System.out.println(ile.size());
        for (int i = K; i < N; i++) {
            System.out.println("bla " + ile.get(A[i - K]));
            if (ile.get(A[i - K]) == 1) {
                ile.remove(A[i - K]);
            } else {
                ile.put(A[i - K], ile.get(A[i - K]) - 1);
            }
            ile.put(A[i], ile.getOrDefault(A[i], 0) + 1);
            System.out.println(ile.size());
        }

    }
}
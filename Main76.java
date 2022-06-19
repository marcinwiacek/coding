import java.io.FileNotFoundException;

public class Main76 {


    //https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
    public static void main(String[] args) throws FileNotFoundException {
        //int    N = 5, S = 12;
//        int A[] = {1,2,3,7,5};

        int N = 10, S = 15;
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int start = 0, suma = 0;

        for (int i = 0; i < N; i++) {
            suma += A[i];
            System.out.println("suma " + suma + " " + start);
            if (suma > S) {
                suma -= A[start];
                start++;
            }
            if (suma == S) {
                System.out.println(start + " " + i);
                break;
            }
        }
    }
}
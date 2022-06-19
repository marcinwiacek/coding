import java.io.FileNotFoundException;

public class Main67 {

    //https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
    public static void main(String[] args) throws FileNotFoundException {
        //   int N = 6;
        //   int arr[] = {3,0,0,2,0,4};

        int N = 4;
        int[] arr = {7, 4, 0, 9};

        //int N = 3;
        //int arr[] = {6,9,9};

        int wysokosc = Math.min(arr[0], arr[N - 1]);
        int ile = 0;
        for (int i = 1; i < N - 1; i++) {
            ile += Math.max(0, wysokosc - arr[i]);
        }
        System.out.println(ile);
    }
}
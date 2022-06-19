public class Main51 {

    //https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1/?page=1&curated[]=1&sortBy=submissions
    //https://ichi.pro/pl/algorytm-kadane-a-programowanie-dynamiczne-jak-i-dlaczego-to-dziala-70199170488125
    static int Kadane(int[] arr) {
        int max_sum = arr[0], max_current = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max_current = Math.max(arr[i], max_current + arr[i]);
            max_sum = Math.max(max_sum, max_current);
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};
        System.out.println(Kadane(arr));
    }

}
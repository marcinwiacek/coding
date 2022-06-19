public class Main80 {

    static int n;

    //code from https://practice.geeksforgeeks.org/problems/maximum-tip-calculator2631/1

    // Recursive function to calculate sum of
    // maximum tip order taken by X and Y
    static int solve(int i, int X, int Y, int[] a, int[] b, int n) {

        if (i == n) return 0; // When all orders have been taken

        if (X <= 0) {         // When X cannot take more orders
            System.out.println("drugi ");
            return b[i] + solve(i + 1, X, Y - 1, a, b, n);
        }

        if (Y <= 0) { // When Y cannot take more orders
            System.out.println("pierwszy ");
            return a[i] + solve(i + 1, X - 1, Y, a, b, n);
        } else {
            // When both can take order
            // calculate maximum out of two
            return Math.max(
                    a[i] + solve(i + 1, X - 1, Y, a, b, n),
                    b[i] + solve(i + 1, X, Y - 1, a, b, n));
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[] a = {1, 4, 3, 2, 7, 5, 9, 6};
        int[] b = {1, 2, 3, 6, 5, 4, 9, 8};
        int n = a.length;
        int x = 4, y = 4;

        System.out.println(solve(0, x, y, a, b, n));
    }
}
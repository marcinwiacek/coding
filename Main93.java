public class Main93 {
    //https://practice.geeksforgeeks.org/problems/two-numbers-with-sum-closest-to-zero1737/1
    public static void main(String[] args) {
        System.out.println(6 / 2 + 6 % 2);
        System.out.println(3 / 2 + 3 % 2);
        //int[] a = {-66, -60, -8};
        int[] a = {-21, -67, -37, -18, 4, -65};
        int s = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (j == i) continue;
                int z = a[i] + a[j];
                System.out.println(i + " " + j + " " + a[i] + " " + a[j] + " " + z);
                if (Math.abs(z) < Math.abs(s)) s = z;
            }
        }
        System.out.println(s);
    }
}
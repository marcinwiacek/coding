public class Main98 {

    //https://practice.geeksforgeeks.org/problems/circle-of-strings4530/1
    public static void main(String[] args) {
        int[] n = new int[256];
        String[] ar = new String[]{"ab", "bc", "cd", "da"};
        for (int i = 0; i < ar.length; i++) {
            n[ar[i].charAt(0)] -= 1;
            n[ar[i].charAt(ar[i].length() - 1)] += 1;
        }
        for (int i = 0; i < 256; i++) {
            if (n[i] != 0) System.out.println("no");
        }
    }
}
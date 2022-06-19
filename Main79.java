public class Main79 {


    //https://practice.geeksforgeeks.org/problems/three-great-candidates0515/1
    public static void main(String[] args) {
        int[] Arr = {10, 3, 5, 6, 20};
        //int Arr[] = {-10, -3, -5, -6, -20};

        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;

        for (int i : Arr) {
            if (i > a) {
                c = b;
                b = a;
                a = i;
            } else if (i > b) {
                c = b;
                b = i;
            } else {
                c = Math.max(c, i);
            }
            System.out.println(a + " " + b + " " + c);
        }

    }
}
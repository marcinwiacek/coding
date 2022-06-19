public class Main88 {

    //https://practice.geeksforgeeks.org/problems/bit-difference-1587115620/1
    public static void main(String[] args) {
        int i = 20 ^ 10;
        while (i > 0) {
            System.out.println(i % 2);
            i = i / 2;
        }
    }
}
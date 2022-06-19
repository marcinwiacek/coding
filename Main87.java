public class Main87 {

    //https://practice.geeksforgeeks.org/problems/bit-difference-1587115620/1
    public static void main(String[] args) {
        int i = 12;
        int pos = 0;
        while (i > 0) {
            System.out.println(i % 2);
            pos++;
            if (i % 2 == 1) {
                System.out.println("bit " + pos);
                break;
            }

            i = i / 2;
        }
    }
}
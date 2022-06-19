public class Main82 {

    //https://practice.geeksforgeeks.org/problems/reverse-bits3556/1
    public static void main(String[] args) {
        long l = 5;
        long w = 0, p2 = (long) Math.pow(2, 31);
        System.out.println(p2);
        while (l > 0) {
            w += p2 * (l % 2);
            l = l / 2;
            p2 = p2 / 2;
        }
        System.out.println(w);
    }
}
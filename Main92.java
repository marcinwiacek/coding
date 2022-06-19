public class Main92 {

    //zapisac w kodzie 62
    public static void main(String[] args) {
        // code here
        String out = "";
        long n = 30540;
        String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        while (n > 0) {
            out = s.charAt((int) (n % 62)) + out;
            n = n / 62;
        }
        System.out.println(out);
    }
}
public class Main83 {

    // string to integer
    public static void main(String[] args) {
        String str = "123";
        int w = 0, p = 1;


        for (int i = str.length() - 1; i >= 0; i--) {
            w += p * (str.charAt(i) - '0');
            p *= 10;
        }
        System.out.println(w);
    }
}
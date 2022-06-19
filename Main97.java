public class Main97 {

    //first repeating character
    public static void main(String[] args) {
        String s = "labc";

        boolean[] n = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            if (n[s.charAt(i)]) {
                System.out.println(s.charAt(i));
                break;
            }
            n[s.charAt(i)] = true;
        }
    }
}
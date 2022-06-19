public class Main91 {
    //https://practice.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1
    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "forgeeksgeeks";

        for (int i = 0; i < s1.length() - 1; i++) {
            System.out.println(s1.substring(i, s1.length() - 1) + "" +
                    (i != 0 ? s1.substring(0, i) : ""));
        }
    }
}
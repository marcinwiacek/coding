import java.io.FileNotFoundException;
import java.util.HashSet;

public class Main71 {
    //https://practice.geeksforgeeks.org/problems/hexadecimal-to-decimal-counter1627/1/?page=2&category[]=modular%20arithmetic&sortBy=submissions
    public static void main(String[] args) throws FileNotFoundException {
        String str = "1FF";
        str += str;
        int n = 3;

        HashSet<String> s = new HashSet<>();
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                System.out.println(j + " " + i + " " + (j + i) + " " + str.substring(j, j + i));
                s.add(str.substring(j, j + i));
            }
        }
        System.out.println(s.size());
    }
}
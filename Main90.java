import java.util.HashMap;

public class Main90 {

    public static void main(String[] args) {
        HashMap<String, Integer> h = new HashMap<>();
        String[] s = {
                "aaa", "bbb", "ccc", "bbb", "aaa", "aaa"};

        for (String s1 : s) {
            h.put(s1, h.getOrDefault(s, 0));

        }
        h.values();
        for (String s1 : s) {
            h.get(s);
            h.put(s1, h.getOrDefault(s, 0));

        }


    }
}
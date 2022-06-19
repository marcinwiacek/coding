import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;

public class Main69 {
    //https://www.youtube.com/watch?v=PIeiiceWe_w
    // we've got numbers assigned to phone keyboard (2..9), phone number and words.
    // find which words are part of this phone number
    public static void main(String[] args) throws FileNotFoundException {
        String[] d = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String phone = "3662277";
        String[] words = {"foo", "bar", "baz", "foobar", "emo", "cap", "car", "cat"};
        LinkedList<String> outputwords = new LinkedList<>();
        long aaaaaa = System.nanoTime();
        for (String word : words) {
            String output = "";
            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < 8; j++) {
                    if (d[j].contains(word.substring(i, i + 1))) {
                        output += (j + 2) + "";
                        break;
                    }
                }
            }
            // System.out.println(output);
            if (phone.contains(output)) outputwords.add(word);
            // System.out.println(word+" "+output);
        }
        System.out.println(outputwords);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        outputwords = new LinkedList<>();
        aaaaaa = System.nanoTime();
        HashMap<String, String> triples = new HashMap<>();
        for (String word : words) {
            String output = "";
            int i = 0;
            while (i < word.length()) {
                String s = triples.get(word.substring(i, i + 3));
                if (s == null) {
                    s = "";
                    for (int j = 0; j < 3; j++) {
                        for (int z = 0; z < 8; z++) {
                            if (d[z].contains(word.substring(i + j, i + j + 1))) {
                                s += (z + 2) + "";
                                break;
                            }
                        }
                    }
                    //System.out.println("triples put "+word.substring(i, i + 3)+" "+ s);
                    triples.put(word.substring(i, i + 3), s);
                }
                output += s + "";
                i += 3;
            }
            if (phone.contains(output)) outputwords.add(word);
            // System.out.println(word+" "+output);
        }
        System.out.println(outputwords);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        outputwords = new LinkedList<>();
        aaaaaa = System.nanoTime();
        triples = new HashMap<>();
        for (String word : words) {
            String output = "";
            int i = 0;
            while (i < word.length()) {
                String s = triples.get(word.substring(i, i + 3));
                if (s == null) {
                    s = "";
                    for (int j = 0; j < 3; j++) {
                        char c = word.charAt(i + j);
                        s += ((((c - 'a') + (c >= 's' ? -1 : 0) + (c >= 'z' ? -1 : 0)) / 3) + 2) + "";
                    }
                    // System.out.println("triples put "+word.substring(i, i + 3)+" "+ s);
                    triples.put(word.substring(i, i + 3), s);
                }
                output += s + "";
                i += 3;
            }
            if (phone.contains(output)) outputwords.add(word);
            // System.out.println(word+" "+output);
        }
        System.out.println(outputwords);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        outputwords = new LinkedList<>();
        aaaaaa = System.nanoTime();
        triples = new HashMap<>(100, 1);
        int i = 0;
        String s = "";
        for (String word : words) {
            String output = "";
            i = 0;
            while (i < word.length()) {
                s = word.substring(i, i + 3);
                if (triples.get(word.substring(i, i + 3)) == null) {
                    s = "";
                    for (int j = 0; j < 3; j++) {
                        char c = word.charAt(i);
                        s += ((((c - 'a') + (c >= 's' ? -1 : 0) + (c >= 'z' ? -1 : 0)) / 3) + 2) + "";
                        i++;
                    }
                    // System.out.println("triples put "+word.substring(i, i + 3)+" "+ s);
                    triples.put(word.substring(i - 3, i), s);
                    output += s + "";
                    continue;
                }
                output += triples.get(s) + "";
                i += 3;
            }
            if (phone.contains(output)) outputwords.add(word);
            // System.out.println(word+" "+output);
        }
        System.out.println(outputwords);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        outputwords = new LinkedList<>();
        aaaaaa = System.nanoTime();
        triples = new HashMap<>(100, 1);
        String[] dd = {"2", "2", "2", "3", "3", "3", "4", "4", "4", "5", "5", "5", "6", "6", "6", "7", "7", "7", "7", "8", "8", "8", "9", "9", "9", "9"};
        for (String word : words) {
            String output = "";
            i = 0;
            while (i < word.length()) {
                s = triples.get(word.substring(i, i + 3));
                if (s == null) {
                    s = dd[word.charAt(i) - 'a'] + dd[word.charAt(i + 1) - 'a'] + dd[word.charAt(i + 2) - 'a'];
                    triples.put(word.substring(i, i + 3), s);
                }
                output += s;
                i += 3;
            }
            if (phone.contains(output)) outputwords.add(word);
            // System.out.println(word+" "+output);
        }
        System.out.println(outputwords);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        outputwords = new LinkedList<>();
        aaaaaa = System.nanoTime();
        triples = new HashMap<>(100, 1);
        String[] ddd = {"2", "2", "2", "3", "3", "3", "4", "4", "4", "5", "5", "5", "6", "6", "6", "7", "7", "7", "7", "8", "8", "8", "9", "9", "9", "9"};
        String output;
        for (String word : words) {
            output = "";
            i = 0;
            while (i < word.length()) {
                s = word.substring(i, i + 3);
                if (triples.get(s) == null) {
                    triples.put(s, ddd[word.charAt(i) - 'a'] + ddd[word.charAt(i + 1) - 'a'] + ddd[word.charAt(i + 2) - 'a']);
                }
                output += triples.get(s);
                i += 3;
            }
            if (phone.contains(output)) outputwords.add(word);
            // System.out.println(word+" "+output);
        }
        System.out.println(outputwords);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        outputwords = new LinkedList<>();
        aaaaaa = System.nanoTime();
        triples = new HashMap<>(100, 1);
        String[] dddd = {"2", "2", "2", "3", "3", "3", "4", "4", "4", "5", "5", "5", "6", "6", "6", "7", "7", "7", "7", "8", "8", "8", "9", "9", "9", "9"};
        String outputd;
        for (String word : words) {
            outputd = "";
            i = 0;
            while (i < word.length()) {
                s = triples.get(word.substring(i, i + 3));
                if (s == null) {
                    s = dddd[word.charAt(i) - 'a'] + dddd[word.charAt(i + 1) - 'a'] + dddd[word.charAt(i + 2) - 'a'];
                    triples.put(word.substring(i, i + 3), s);
                }
                outputd += s;
                i += 3;
            }
            if (phone.contains(outputd)) outputwords.add(word);
            // System.out.println(word+" "+output);
        }
        System.out.println(outputwords);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        outputwords = new LinkedList<>();
        aaaaaa = System.nanoTime();
        String[] decoded = new String[phone.length()];
        for (int ii = 0; ii < phone.length(); ii++) {
            decoded[ii] = d[phone.charAt(ii) - '0' - 2];
        }
        int startindex = 0;
        for (String word : words) {
            for (int ii = 0; ii < decoded.length; ii++) {
                if (decoded[ii].contains(word.substring(0, 1))) {
                    startindex = ii + 1;
                    break;
                }
            }
            for (int ii = 1; ii < word.length(); ii++) {
                if (decoded[startindex].contains(word.substring(ii, ii + 1))) {
                    startindex++;
                } else {
                    startindex = -1;
                    break;
                }
            }
            if (startindex != -1) outputwords.add(word);
        }
        System.out.println(outputwords);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));


    }
}
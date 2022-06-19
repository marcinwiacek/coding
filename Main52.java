import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Main52 {

    static void first(String[] strings) {
        long bbbbbb = System.nanoTime();
        HashSet<String> found = new HashSet<>();
        LinkedList<Integer> lengths = new LinkedList<>();
        LinkedList<c> toCheck = new LinkedList<>();
        HashMap<Integer, LinkedList<String>> words = new HashMap<>();
        for (String word : strings) {
            if (words.get(word.length()) == null) {
                words.put(word.length(), new LinkedList<>());
                lengths.add(word.length());
            }
            words.get(word.length()).add(word);
            toCheck.addLast(new c(word, word));
        }

        while (!toCheck.isEmpty()) {
            for (int i : lengths) {
                if (i > toCheck.getFirst().tocheck.length()) continue;
                for (String word : words.get(i)) {
                    if (word.equals(toCheck.getFirst().original)) continue;
                    String w = toCheck.getFirst().tocheck.replace(word, "");
                    if (w.isEmpty()) {
                        found.add(toCheck.getFirst().original);
                    } else if (toCheck.getFirst().tocheck.length() != w.length()) {
                        toCheck.addLast(new c(toCheck.getFirst().original, w));
                    }
                }
            }
            toCheck.removeFirst();
        }

        System.out.println(found);
        System.out.println("nano7 " + (System.nanoTime() - bbbbbb));
    }

    static void second(String[] strings) {
        long bbbbbb = System.nanoTime();

        HashSet<String> found = new HashSet<>(strings.length, 1);
        LinkedList<Integer> lengths = new LinkedList<>();
        HashMap<Integer, LinkedList<String>> lengthWithWords = new HashMap<>(strings.length, 1);
        HashMap<String, LinkedList<String>> toCheck = new HashMap<>(strings.length, 1);

        for (String word : strings) {
            if (lengthWithWords.get(word.length()) == null) {
                lengthWithWords.put(word.length(), new LinkedList<>());
                lengths.add(word.length());
            }
            lengthWithWords.get(word.length()).add(word);
            toCheck.put(word, new LinkedList() {{
                add(word);
            }});
        }

        for (String checkIt : strings) {
            Boolean f = false;
            while (!toCheck.get(checkIt).isEmpty()) {
                String w = toCheck.get(checkIt).getFirst();
                if (found.contains(w)) {
                    found.add(checkIt);
                    break;
                }
                for (int i : lengths) {
                    // System.out.println(i);
                    if (i > w.length()) continue;
                    for (String word : lengthWithWords.get(i)) {
                        if (word.equals(checkIt)) continue;
                        String w2 = w.replace(word, "");
                        if (w2.isEmpty()) {
                            found.add(checkIt);
                            f = true;
                            break;
                        }
                        if (w2.length() != w.length()) {
                            toCheck.get(checkIt).addLast(w2);
                        }
                    }
                    if (f) break;
                }
                if (f) break;
                toCheck.get(checkIt).remove(w);
            }
        }

        System.out.println(found);
        System.out.println("nano7 " + (System.nanoTime() - bbbbbb));
    }

    static void third(String[] strings) {
        long bbbbbb = System.nanoTime();

        HashSet<String> found = new HashSet<>(strings.length, 1);
        LinkedList<Integer> lengths = new LinkedList<>();
        HashMap<Integer, LinkedList<String>> lengthWithWords = new HashMap<>(strings.length, 1);
        HashMap<String, LinkedList<String>> toCheck = new HashMap<>(strings.length, 1);

        for (String word : strings) {
            if (lengthWithWords.get(word.length()) == null) {
                lengthWithWords.put(word.length(), new LinkedList<>());
                lengths.add(word.length());
            }
            lengthWithWords.get(word.length()).add(word);
            toCheck.put(word, new LinkedList<String>() {{
                add(word);
            }});
        }
        Collections.sort(lengths);
        if (lengths.contains(1)) {
            lengths.remove((Integer) 1);
            lengths.addLast(1);
        }

        while (!lengths.isEmpty()) {
            int l = lengths.getFirst();
            if (l == 1) break;
            for (String checkIt : lengthWithWords.get(l)) {
                Boolean f = false;
                while (!toCheck.get(checkIt).isEmpty()) {
                    String w = toCheck.get(checkIt).getFirst();
                    if (found.contains(w)) {
                        found.add(checkIt);
                        break;
                    }
                    for (int i : lengths) {
                        if (i > w.length()) continue;
                        for (String word : lengthWithWords.get(i)) {
                            String w2 = w.replace(word, "");
                            if (w2.isEmpty()) {
                                found.add(checkIt);
                                f = true;
                                break;
                            }
                            if (w2.length() != w.length()) {
                                toCheck.get(checkIt).addLast(w2);
                            }
                        }
                        if (f) break;
                    }
                    if (f) break;
                    toCheck.get(checkIt).remove(w);
                }
            }
            lengthWithWords.remove(l);
            lengths.remove((Integer) l);
        }

        System.out.println(found);
        System.out.println("nano7 " + (System.nanoTime() - bbbbbb));
    }

    static void forth(String[] strings) {
        long bbbbbb = System.nanoTime();

        HashSet<String> found = new HashSet<>(strings.length, 1);
        LinkedList<Integer> lengths = new LinkedList<>();
        HashMap<Integer, LinkedList<String>> lengthWithWords = new HashMap<>(strings.length, 1);
        HashMap<String, LinkedList<String>> toCheck = new HashMap<>(strings.length, 1);

        for (String word : strings) {
            if (lengthWithWords.get(word.length()) == null) {
                lengthWithWords.put(word.length(), new LinkedList<>());
                lengths.add(word.length());
            }
            lengthWithWords.get(word.length()).add(word);
            toCheck.put(word, new LinkedList<String>() {{
                add(word);
            }});
        }
        Collections.sort(lengths);
        if (lengths.contains(1)) {
            lengths.remove((Integer) 1);
            lengths.addLast(1);
        }

        while (!lengths.isEmpty()) {
            int l = lengths.getFirst();
            if (l == 1) break;
            for (String checkIt : lengthWithWords.get(l)) {
                Boolean f = false;
                for (String w : toCheck.get(checkIt)) {
                    if (found.contains(w)) {
                        f = true;
                        found.add(checkIt);
                        break;
                    }
                }
                if (!f) {
                    while (!toCheck.get(checkIt).isEmpty()) {
                        String w = toCheck.get(checkIt).getFirst();
                        for (int i : lengths) {
                            if (i > w.length()) continue;
                            for (String word : lengthWithWords.get(i)) {
                                String w2 = w.replace(word, "");
                                if (w2.isEmpty()) {
                                    found.add(checkIt);
                                    f = true;
                                    break;
                                }
                                if (w2.length() != w.length()) {
                                    toCheck.get(checkIt).addLast(w2);
                                }
                            }
                            if (f) break;
                        }
                        if (f) break;
                        toCheck.get(checkIt).remove(w);
                    }
                }
            }
            lengthWithWords.remove(l);
            lengths.remove((Integer) l);
        }

        System.out.println(found);
        System.out.println("nano7 " + (System.nanoTime() - bbbbbb));
    }

    //https://www.youtube.com/watch?v=QGVCnjXmrNg problem 3
    // which string is concatenation of others?
    // (three own solutions - one seems to be nlogn, one n^2 or more)
    public static void main(String[] args) {
        String[] strings = {"r", "ogr", "pets", "e", "t", "s", "p", "q",
                "r", "ogr", "pets", "e", "t", "s", "p", "q", "dogcat", "catscatsdog",
                "w", "c", "a", "t", "ca", "o", "g", "d", "og", "dog", "cat", "cats", "catsdog", "s"};

      //  forth(strings);
        third(strings);
        second(strings);
        first(strings);
    }

    private static class c {
        String original;
        String tocheck;

        c(String original, String tocheck) {
            this.original = original;
            this.tocheck = tocheck;
        }
    }

    static class l {
        String word;
        LinkedList<String> toCheck;

        l(String word, LinkedList<String> toCheck) {
            this.word = word;
            this.toCheck = toCheck;
        }
    }
}
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Main61 {

    private static void decode(String data, int index, String prefix, ArrayList<String> answers) {
        if (index > data.length() - 1) {
            answers.add(prefix);
            return;
        }
        if (data.charAt(index) == '0') return;
        decode(data, index + 1, prefix + (char) (data.charAt(index) - '0' - 1 + 'a'), answers);
        if (index < data.length() - 1 && (data.charAt(index) == '1' || (data.charAt(index) == '2' && data.charAt(index + 1) <= '6'))) {
            decode(data, index + 2, prefix + (char) ((data.charAt(index) - '0') * 10 + (data.charAt(index + 1) - '0') - 1 + 'a'), answers);
        }
    }

    private static String[] decode2(String data) {
        if (data.isEmpty()) return new String[]{""};
        if (data.charAt(0) == '0') return new String[]{""};
        if (data.length() > 1 && (data.charAt(0) == '1' || (data.charAt(0) == '2' && data.charAt(1) <= '6'))) {
            String[] s = decode2(data.substring(2));
            String[] s2 = new String[s.length * 2];
            for (int i = 0; i < s.length; i++) {
                s2[i * 2] = (char) ((data.charAt(0) - '0') * 10 + (data.charAt(1) - '0') - 1 + 'a') + s[i];
                s2[i * 2 + 1] = (char) (data.charAt(0) - '0' - 1 + 'a') + "" + (char) (data.charAt(1) - '0' - 1 + 'a') + s[i];
            }
            return s2;
        }
        String[] s = decode2(data.substring(1));
        for (int i = 0; i < s.length; i++) {
            s[i] = (char) (data.charAt(0) - '0' - 1 + 'a') + s[i];
        }
        return s;
    }

    private static String[] decode3(String data) {
        if (data.isEmpty() || data.charAt(0) == '0') return new String[]{""};
        byte b = (byte) ((data.charAt(0) - '0'));
        if (data.length() > 1 && (b == 1 || (b == 2 && data.charAt(1) <= '6'))) {
            String[] s = decode3(data.substring(2));
            String[] s2 = new String[s.length * 2];
            char c = (char) (b * 10 + (data.charAt(1) - '0') - 1 + 'a');
            String c2 = (char) (b - 1 + 'a') + "" + (char) (data.charAt(1) - '0' - 1 + 'a');
            for (int i = 0; i < s.length; i++) {
                s2[i * 2] = c + s[i];
                s2[i * 2 + 1] = c2 + s[i];
            }
            return s2;
        }
        String[] s = decode3(data.substring(1));
        char c = (char) (b - 1 + 'a');
        for (int i = 0; i < s.length; i++) {
            s[i] = c + s[i];
        }
        return s;
    }

    private static LinkedList<String> decode4(String data) {
        LinkedList<String> result = new LinkedList<>();
        LinkedList<c> toProcess = new LinkedList<>();
        toProcess.addLast(new c(data, ""));
        while (!toProcess.isEmpty()) {
            c s = toProcess.getFirst();
            toProcess.removeFirst();
            if (s.data.charAt(0) == '0') continue;
            byte b = (byte) ((s.data.charAt(0) - '0'));
            if (s.data.length() > 1 && (b == 1 || (b == 2 && s.data.charAt(1) <= '6'))) {
                char c = (char) (b * 10 + (s.data.charAt(1) - '0') - 1 + 'a');
                String c2 = (char) (b - 1 + 'a') + "" + (char) (s.data.charAt(1) - '0' - 1 + 'a');
                if (s.data.length() == 2) {
                    result.add(s.processed + c);
                    result.add(s.processed + c2);
                } else {
                    toProcess.addLast(new c(s.data.substring(2), s.processed + c));
                    toProcess.addLast(new c(s.data.substring(2), s.processed + c2));
                }
                continue;
            }
            char c = (char) (b - 1 + 'a');
            if (s.data.length() == 1) {
                result.add(s.processed + c);
            } else {
                toProcess.addLast(new c(s.data.substring(1), s.processed + c));
            }
        }
        return result;
    }

    private static LinkedList<String> decode5(String data) {
        LinkedList<String> result = new LinkedList<>();
        Stack<c> toProcess = new Stack<>();
        toProcess.push(new c(data, ""));
        while (!toProcess.isEmpty()) {
            c s = toProcess.pop();
            if (s.data.charAt(0) == '0') continue;
            byte b = (byte) ((s.data.charAt(0) - '0'));
            if (s.data.length() > 1 && (b == 1 || (b == 2 && s.data.charAt(1) <= '6'))) {
                char c = (char) (b * 10 + (s.data.charAt(1) - '0') - 1 + 'a');
                String c2 = (char) (b - 1 + 'a') + "" + (char) (s.data.charAt(1) - '0' - 1 + 'a');
                if (s.data.length() == 2) {
                    result.add(s.processed + c);
                    result.add(s.processed + c2);
                } else {
                    toProcess.push(new c(s.data.substring(2), s.processed + c));
                    toProcess.push(new c(s.data.substring(2), s.processed + c2));
                }
                continue;
            }
            char c = (char) (b - 1 + 'a');
            if (s.data.length() == 1) {
                result.add(s.processed + c);
            } else {
                toProcess.push(new c(s.data.substring(1), s.processed + c));
            }
        }
        return result;
    }

    //https://www.youtube.com/watch?v=qli-JCrSwuk
    //decoding number into a=1...z=26
    public static void main(String[] args) throws FileNotFoundException {

        //BŁAD
       /* long aaaaaa = System.nanoTime();
        ArrayList<String> a = new ArrayList<>();
        decode("123451214", 0, "", a);
        System.out.println(a);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));*/

        long aaaaaa = System.nanoTime();
        System.out.println(decode4("123451214"));
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        System.out.println(Arrays.asList(decode2("123451214")));
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        System.out.println(Arrays.asList(decode3("123451214")));
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        System.out.println(decode5("123451214"));
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

    }

    static class c {
        String data;
        String processed;

        c(String data, String processed) {
            this.data = data;
            this.processed = processed;
        }
    }


}
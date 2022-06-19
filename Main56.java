import java.io.FileNotFoundException;

public class Main56 {

    //https://www.youtube.com/watch?v=r1MXwyiGi_U
    // longest palyndromic;
    public static void main(String[] args) throws FileNotFoundException {
        String S = "alaalaalamakotoaatestsetaaonetwo";
        int StartPosition = S.length() / 2;
        int maxlength = 0;
        int positionwithpalindrom = -1;
        for (int position = StartPosition; position >= 0; position--) {
            if (position < maxlength / 2) break;
            int len = 1;
            while (true) {
                if (position - len >= 0 && position + len < S.length() && S.charAt(position - len) == S.charAt(position + len)) {
                    len++;
                } else {
                    if (len > maxlength) {
                        maxlength = len;
                        positionwithpalindrom = position;
                    }
                    break;
                }
            }
        }
        for (int position = StartPosition + 1; position < S.length() - 1; position++) {
            if ((S.length() - position) < maxlength / 2) break;
            int len = 1;
            while (true) {
                if (position - len >= 0 && position + len < S.length() && S.charAt(position - len) == S.charAt(position + len)) {
                    len++;
                } else {
                    if (len > maxlength) {
                        maxlength = len;
                        positionwithpalindrom = position;
                    }
                    break;
                }
            }
        }
        System.out.println(S);
        System.out.println(S.substring(positionwithpalindrom - maxlength + 1, positionwithpalindrom + maxlength));
    }

}
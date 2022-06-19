import java.io.FileNotFoundException;

public class Main64 {

    private static int[][] getTimes(String[][] first) {
        int[][] firstint = new int[first.length][2];
        for (int i = 0; i < first.length; i++) {
            int[] x = new int[2];
            for (int j = 0; j < 2; j++) {
                String[] s = first[i][j].split(":");
                int t = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
                x[j] = t;
            }
            firstint[i] = x;
        }
        return firstint;
    }

    private static int[][] findslots(int[][] first, String[] firstopen) {
        String[] s = firstopen[0].split(":");
        int starttime = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        s = firstopen[1].split(":");
        int endtime = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);

        int[][] firstint = new int[first.length - 1 + (starttime < first[0][0] ? 1 : 0) + (endtime > first[first.length - 1][1] ? 1 : 0)][2];
        for (int i = 0; i < first.length - 1; i++) {
            int[] x = new int[2];
            x[0] = first[i][1];
            x[1] = first[i + 1][0];
            firstint[i + (starttime < first[0][0] ? 1 : 0)] = x;
        }
        if (starttime < first[0][0]) {
            int[] x = new int[2];
            x[0] = starttime;
            x[1] = first[0][0];
            firstint[0] = x;
        }
        if (endtime > first[first.length - 1][1]) {
            int[] x = new int[2];
            x[0] = first[first.length - 1][1];
            x[1] = endtime;
            firstint[firstint.length - 1] = x;
        }
        return firstint;
    }

    //https://www.youtube.com/watch?v=3Q_oYDQ2whs
    //find free slots for both calendars with time >= length
    public static void main(String[] args) throws FileNotFoundException {
        String[][] first = {{"9:00", "10:30"}, {"12:00", "13:00"}, {"16:00", "18:00"}};
        String[] firstopen = {"9:00", "20:00"};

        String[][] second = {{"10:00", "11:30"}, {"12:30", "14:30"}, {"14:30", "15:00"}, {"16:00", "17:00"}};
        String[] secondopen = {"10:00", "18:30"};

        int length = 30;

        int[][] firstint = findslots(getTimes(first), firstopen);
        int[][] secondint = findslots(getTimes(second), secondopen);
        for (int i = 0; i < firstint.length; i++) {
            System.out.print(firstint[i][0] / 60 + ":" + firstint[i][0] % 60 + "-" + firstint[i][1] / 60 + ":" + firstint[i][1] % 60 + " ");
        }
        System.out.println();
        for (int i = 0; i < secondint.length; i++) {
            System.out.print(secondint[i][0] / 60 + ":" + secondint[i][0] % 60 + "-" + secondint[i][1] / 60 + ":" + secondint[i][1] % 60 + " ");
        }
        System.out.println();

        int j = 0;
        for (int i = 0; i < firstint.length; i++) {
            do {
                System.out.println("comparing " + firstint[i][0] / 60 + " " + firstint[i][0] % 60 + " " + secondint[j][0] / 60 + " " + secondint[j][0] % 60);
                if (firstint[i][1] < secondint[j][0]) break;
                int starttime = Math.max(firstint[i][0], secondint[j][0]);
                int endtime = Math.min(firstint[i][1], secondint[j][1]);
                if (endtime <= starttime || endtime - starttime < length) {
                    j++;
                    if (j == second.length) return;
                    continue;
                }
                System.out.println(starttime / 60 + ":" + starttime % 60 + " " + endtime / 60 + ":" + endtime % 60);
                break;
            } while (true);
        }


    }

}
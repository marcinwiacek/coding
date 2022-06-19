import java.util.Arrays;
import java.util.Comparator;

public class Main100 {
    //https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
    public static int maxMeetings(int[] start, int[] end, int n) {
        // add your code here
        Meeting[] arr = new Meeting[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Meeting(start[i], end[i]);
        }
        Arrays.sort(arr, new Comparator<Meeting>() {
            public int compare(Meeting m1, Meeting m2) {
                return m1.end - m2.end;
            }
        });
        int i = 0;
        int res = 1;
        for (int j = 1; j < n; j++) {
            if (arr[j].start > arr[i].end) {
                i = j;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//System.out.println(maxMeetings(new int[]{1,3,0,5,8,5},new int[]{2,4,6,7,9,9}, 6));
        System.out.println(maxMeetings(new int[]{10, 12, 21}, new int[]{20, 25, 30}, 3));
    }


    public static class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
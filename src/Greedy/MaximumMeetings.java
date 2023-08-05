package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Find the maximum number od meetings accommodated in a room.
 */
public class MaximumMeetings {

    public static void main(String[] args) {
        List<Integer> startTime = List.of(1, 3, 0, 5, 8, 5);
        List<Integer> endTime = List.of(2, 4, 6, 7, 9, 9);

        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < startTime.size(); i++) {
            meetings.add(new Meeting(i + 1, startTime.get(i), endTime.get(i)));
        }

        List<Integer> result = new ArrayList<>();
        result.add(meetings.get(0).no);
        Meeting previous = meetings.get(0);

        for (int i = 1; i < meetings.size(); i++) {
            Meeting current = meetings.get(i);
            if (current.start > previous.finish) {
                result.add(current.no);
                previous = current;
            }
        }
        System.out.println(result);
    }

    private static class ItemComparator implements Comparator<Meeting> {
        @Override
        public int compare(Meeting o1, Meeting o2) {
            return Integer.compare(o1.finish, o2.finish);
        }
    }

    private static class Meeting {
        Integer no;
        Integer start;
        Integer finish;

        public Meeting(Integer no, Integer start, Integer finish) {
            this.no = no;
            this.start = start;
            this.finish = finish;
        }

        @Override
        public String toString() {
            return "Meeting{" + "start=" + start + ", finish=" + finish + '}';
        }
    }
}

package Daily.LeetCode;

import java.util.PriorityQueue;

public class SeatReservationManager {

    static class SeatManager {
        private final PriorityQueue<Integer> availableSeats;

        public SeatManager(int n) {
            availableSeats = new PriorityQueue<>();
            for (int seatNumber = 1; seatNumber <= n; ++seatNumber) availableSeats.offer(seatNumber);
        }

        public int reserve() {
            return availableSeats.size() > 0 ? availableSeats.poll() : -1;
        }

        public void unreserve(int seatNumber) {
            availableSeats.offer(seatNumber);
        }
    }
}

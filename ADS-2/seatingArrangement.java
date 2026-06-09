public class seatingArrangement {
        public boolean canSeatAllPeople(int k, int[] seats) {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                // Check for invalid pre-existing adjacent occupied seats
                if (i > 0 && seats[i - 1] == 1) {
                    return false;
                }
            } else {
                // Check if both adjacent seats are empty or out of bounds
                boolean leftEmpty = (i == 0 || seats[i - 1] == 0);
                boolean rightEmpty = (i == seats.length - 1 || seats[i + 1] == 0);
                
                if (leftEmpty && rightEmpty) {
                    seats[i] = 1; // Occupy the seat
                    k--;          // One less person to seat
                }
            }
        }
        return k <= 0;
    }
}

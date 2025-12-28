class DonutOrderTimeCalculator {
    
    // Method to calculate the minimum time to make 'n' donuts
    public int minTime(int[] ranks, int n) {
        int left = 1, right = ranks[0] * n * (n + 1) / 2; // Maximum time when one chef does all the work
        
        // Binary search to find the minimum time
        while (left < right) {
            int mid = left + (right - left) / 2;
            int donutsMade = 0;
            
            // Calculate total donuts that can be made in 'mid' time by all chefs
            for (int rank : ranks) {
                donutsMade += maxDonutsInTime(mid, rank);
            }
            
            // Check if we can make enough donuts in 'mid' time
            if (donutsMade >= n) {
                right = mid; // We can make enough donuts, try a smaller time
            } else {
                left = mid + 1; // We need more time to make the donuts
            }
        }
        
        return left; // Return the minimum time found
    }
    
    // Helper function to calculate how many donuts a chef can make in a given 'time' based on their 'rank'
    private int maxDonutsInTime(int time, int rank) {
        int donuts = 0;
        int currentTime = 0;
        
        // Calculate the maximum number of donuts a chef with 'rank' can make within the 'time'
        while (currentTime + (donuts + 1) * rank <= time) {
            donuts++;
            currentTime += donuts * rank;
        }
        
        return donuts;
    }

    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        DonutOrderTimeCalculator calculator = new DonutOrderTimeCalculator();
        
        // Example input
        int[] ranks = {1, 2, 3, 4};
        int n = 10;
        
        // Call the method and print the result
        int result = calculator.minTime(ranks, n);
        System.out.println("Minimum time to fulfill all orders: " + result);
    }
}

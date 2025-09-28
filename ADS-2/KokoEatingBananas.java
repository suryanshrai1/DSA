public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int ans = 0;
        int low = 1, high = Integer.MIN_VALUE;
        for (int pile : piles) {
            high = Math.max(pile, high);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(piles, h, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] piles, int h, int mid) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + mid - 1) / mid;  // This calculates the number of hours needed to eat a pile with speed 'mid'
        }
        return time <= h;
    }

    public static void main(String[] args) {
        KokoEatingBananas solution = new KokoEatingBananas();
        
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        
        int result = solution.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result);  // Output should be 4
    }
}

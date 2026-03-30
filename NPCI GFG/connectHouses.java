
import java.util.*;

public class connectHouses {
    public int minCost(int[][] houses) {
        int n = houses.length;
        if (n == 0) return 0;

        // minEdges[i] stores the minimum cost to connect house i to the MST
        int[] minEdges = new int[n];
        Arrays.fill(minEdges, Integer.MAX_VALUE);
        boolean[] inMST = new boolean[n];
        
        int totalCost = 0;
        int edgesUsed = 0;
        
        // Start with the first house (index 0)
        minEdges[0] = 0;

        while (edgesUsed < n) {
            int currHouse = -1;
            
            // Find the house with the smallest edge cost that isn't in the MST yet
            for (int i = 0; i < n; i++) {
                if (!inMST[i] && (currHouse == -1 || minEdges[i] < minEdges[currHouse])) {
                    currHouse = i;
                }
            }

            // Add this house to MST
            inMST[currHouse] = true;
            totalCost += minEdges[currHouse];
            edgesUsed++;

            // Update distances to all other houses from the newly added house
            for (int nextHouse = 0; nextHouse < n; nextHouse++) {
                if (!inMST[nextHouse]) {
                    int dist = Math.abs(houses[currHouse][0] - houses[nextHouse][0]) +
                               Math.abs(houses[currHouse][1] - houses[nextHouse][1]);
                    
                    if (dist < minEdges[nextHouse]) {
                        minEdges[nextHouse] = dist;
                    }
                }
            }
        }
        return totalCost;
    }
}


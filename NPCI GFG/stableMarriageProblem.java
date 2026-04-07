import java.util.*;

public class stableMarriageProblem {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;

        int[] manMatches = new int[n];
        int[] womanMatches = new int[n];
        int[] nextProposal = new int[n];

        Arrays.fill(manMatches, -1);
        Arrays.fill(womanMatches, -1);

        int[][] womanRank = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                womanRank[i][women[i][j]] = j;
            }
        }

        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) freeMen.add(i);

        while (!freeMen.isEmpty()) {
            int man = freeMen.poll();
            int woman = men[man][nextProposal[man]];
            nextProposal[man]++;

            if (womanMatches[woman] == -1) {
                womanMatches[woman] = man;
                manMatches[man] = woman;
            } else {
                int otherMan = womanMatches[woman];
                if (womanRank[woman][man] < womanRank[woman][otherMan]) {
                    womanMatches[woman] = man;
                    manMatches[man] = woman;
                    manMatches[otherMan] = -1;
                    freeMen.add(otherMan);
                } else {
                    freeMen.add(man);
                }
            }
        }
        return manMatches;
    }
}
import java.util.ArrayList;

public class PoliceAndThieves {

    public int catchThieves(char[] arr, int k) {
        ArrayList<Integer> police = new ArrayList<>();
        ArrayList<Integer> thieves = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else if (arr[i] == 'T') {
                thieves.add(i);
            }
        }

        int pi = 0, ti = 0, count = 0;

        while (pi < police.size() && ti < thieves.size()) {
            if (Math.abs(police.get(pi) - thieves.get(ti)) <= k) {
                count++;
                pi++;
                ti++;
            } else if (police.get(pi) < thieves.get(ti)) {
                pi++;
            } else {
                ti++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        PoliceAndThieves solution = new PoliceAndThieves();

        char[] arr = {'P', 'T', 'T', 'P', 'T'};
        int k = 1;

        int result = solution.catchThieves(arr, k);
        System.out.println("Maximum thieves caught: " + result);
    }
}

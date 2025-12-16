package Graph;
import java.util.Scanner;
import java.util.ArrayList;

class Pair {
    int first;// vertex
    int second; // weight

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class DefineWeightGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // vertices
        int e = sc.nextInt(); // edges

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        // reading edge
        for(int i = 0; i<e; i++){
            int u = sc.nextInt();// start
            int v = sc.nextInt(); // end
            int w = sc.nextInt();// weight

            // undirected graph
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));// in case of directed singe(this won't be there)

        }
        for(int i =0; i<n; i++){
            System.out.print(i+" ");
            for(Pair p : adj.get(i)){
                System.out.print(p.first+", "+p.second);
            }
            System.out.println();
        }

    }

}

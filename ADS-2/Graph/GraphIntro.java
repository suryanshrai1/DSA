package Graph;
import java.util.ArrayList;
import java.util.Scanner;

// class Pair {
//     int first;
//     int second;

//     Pair(int first, int second) {
//         this.first = first;
//         this.second = second;
//     }
// }

public class GraphIntro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        // int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        // edge 1---2
        adj.get(1).add(2);
        adj.get(2).add(1);

        //for directed
        adj.get(3).add(4);

        for (int i = 1; i < n; i++) {
            for(int j = 1; j<adj.get(i).size(); j++){
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();

        }

    // the adjacency matrix way

        // int [][] adj = new int[n+1][n+1];

        // adj[1][2] = 1;
        // adj[2][1] = 1;

        // adj[2][3] = 1;
        // adj[3][2] = 1;

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(adj[i][j]);
        //     }
        //     System.out.println();
        // }
    }
}

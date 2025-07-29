/*A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach the destination. The rat can move only in two directions: forward and down. 

In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path from source to destination. Note that this is a simple version of the typical Maze problem. For example, a more complex version can be that the rat can move in 4 directions and a more complex version can be with a limited number of moves. */

class rateMaze {

    static int N;

    static void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }

    static boolean isSafe(int maze[][], int i, int j) {
        return (i < N && j < N && maze[i][j] == 1);
    }

    static boolean solveMaze(int maze[][]) {
        int sol[][] = new int[N][N];

        if (solveMazeRec(maze, 0, 0, sol) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    static boolean solveMazeRec(int maze[][], int i, int j, int sol[][]) {
        if (i == N - 1 && j == N - 1 && maze[i][j] == 1) {
            sol[i][j] = 1;
            return true;
        }

        if (isSafe(maze, i, j) == true) {
            sol[i][j] = 1;

            if (solveMazeRec(maze, i + 1, j, sol))
                return true;

            if (solveMazeRec(maze, i, j + 1, sol))
                return true;

            sol[i][j] = 0;
        }

        return false;
    }

    public static void main(String args[]) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        N = maze.length;
        solveMaze(maze);
    }
}
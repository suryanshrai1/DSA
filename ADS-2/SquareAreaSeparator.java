public class SquareAreaSeparator {

    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = 1e18, high = -1e18;

        for (int[] s : squares) {
            double y = s[1], l = s[2];
            totalArea += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        for (int i = 0; i < 80; i++) {
            double mid = (low + high) / 2.0;
            double areaBelow = 0;

            for (int[] s : squares) {
                double y = s[1], l = s[2];

                if (mid <= y) {
                    continue;
                } else if (mid >= y + l) {
                    areaBelow += l * l;
                } else {
                    areaBelow += l * (mid - y);
                }
            }

            if (areaBelow * 2 < totalArea) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        SquareAreaSeparator solver = new SquareAreaSeparator();

        // Example input: {x, y, sideLength}
        int[][] squares = {
            {0, 0, 2},
            {1, 1, 2},
            {2, 3, 1}
        };

        double result = solver.separateSquares(squares);
        System.out.println("Y-coordinate of separating line: " + result);
    }
}

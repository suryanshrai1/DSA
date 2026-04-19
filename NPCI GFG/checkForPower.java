public class checkForPower {
    public boolean isPower(int x, int y) {
        if (y == 1) return true;
        
        if (x == 1) return false;
        
        long pow = 1;
        while (pow < y) {
            pow = pow * x;
        }
        return (pow == y);
    }
}

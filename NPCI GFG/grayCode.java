import java.util.*;

public class grayCode {
    public ArrayList<String> graycode(int n) {
        ArrayList<String> result = new ArrayList<>();
        // Total number of codes is 2^n
        int totalCodes = 1 << n; //2^n

        for (int i = 0; i < totalCodes; i++) {
            // Generating the ith Gray code number
            int grayNum = i ^ (i >> 1);
            String binaryString = Integer.toBinaryString(grayNum);
            while (binaryString.length() < n) {
                binaryString = "0" + binaryString;
            }
            result.add(binaryString);
        }
        return result;
    }
}
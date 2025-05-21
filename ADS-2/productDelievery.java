import java.util.Scanner;

public class productDelievery {
    public static int[] prodDelivery(int[] orderID) {
        int[] answer = new int[orderID.length];
        
        for (int i = 0; i < orderID.length; i++) {
            int totalProducts = 0;
            int currentOrderID = orderID[i];
            
            // Calculate the total number of products delivered
            while (currentOrderID > 0) {
                totalProducts += currentOrderID % 10; // Add the last digit
                currentOrderID /= 10; // Remove the last digit
            }
            
            answer[i] = totalProducts; // Store the result for the current client
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // Input for number of clients
        int numOfClients = in.nextInt();
        int[] orderID = new int[numOfClients];
        
        // Input for orderIDs
        for (int idx = 0; idx < numOfClients; idx++) {
            orderID[idx] = in.nextInt();
        }
        
        // Get the result
        int[] result = prodDelivery(orderID);
        
        // Print the result
        for (int idx = 0; idx < result.length; idx++) {
            System.out.print(result[idx] + " ");
        }
        
        in.close();
    }
}
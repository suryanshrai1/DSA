import java.util.*;

public class FirstNonRepeatingCharacter {
    public static void findFirstNonRepeatingCharacter(String stream) {
        // HashMap to store frequency of each character
        Map<Character, Integer> charFrequency = new HashMap<>();
        
        // Queue to store characters whose frequency is 1
        Queue<Character> queue = new LinkedList<>();
        
        // Process each character in the stream
        for (char c : stream.toCharArray()) {
            // Increment frequency of the character
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
            
            // If it's the first time this character appears, add it to the queue
            if (charFrequency.get(c) == 1) {
                queue.offer(c);
            }
            
            // Remove characters from the queue that are no longer non-repeating
            while (!queue.isEmpty() && charFrequency.get(queue.peek()) > 1) {
                queue.poll();
            }
            
            // Print the first non-repeating character in the stream
            if (!queue.isEmpty()) {
                System.out.println("First Non-Repeating Character: " + queue.peek());
            } else {
                System.out.println("No non-repeating character");
            }
        }
    }
    
    public static void main(String[] args) {
        String stream = "aabcc";
        findFirstNonRepeatingCharacter(stream);
    }
}

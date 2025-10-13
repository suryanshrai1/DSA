import java.util.*;

public class AnagramRemover {

    // Method to find the frequency of characters in a given word
    public int[] findFreq(String word) {
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }
        return freq;
    }

    // Method to check if two frequency arrays are equal
    public boolean check(int[] freqA, int[] freqB) {
        for (int i = 0; i < 26; i++) {
            if (freqA[i] != freqB[i]) {
                return false;
            }
        }
        return true;
    }

    // Main method that removes anagrams from a list of words
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        int[] prevFreq = findFreq(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            int[] curFreq = findFreq(words[i]);
            if (!check(prevFreq, curFreq)) {
                ans.add(words[i]);
                prevFreq = curFreq;
            }
        }
        return ans;
    }

    // Main method to run the program and test the functionality
    public static void main(String[] args) {
        AnagramRemover solution = new AnagramRemover();
        
        // Sample input
        String[] words = {"abba", "baba", "baab", "cd", "efg", "xyz"};
        
        // Remove anagrams and display the result
        List<String> result = solution.removeAnagrams(words);
        System.out.println(result); // Output: [abba, cd, efg, xyz]
    }
}

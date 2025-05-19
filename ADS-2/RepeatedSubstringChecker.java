public class RepeatedSubstringChecker {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String modified = doubled.substring(1, doubled.length() - 1);
        return modified.contains(s);
    }

    // Example usage and testing
    public static void main(String[] args) {
        RepeatedSubstringChecker checker = new RepeatedSubstringChecker();
        System.out.println(checker.repeatedSubstringPattern("abab"));         // true
        System.out.println(checker.repeatedSubstringPattern("aba"));          // false
        System.out.println(checker.repeatedSubstringPattern("abcabcabcabc")); // true
    }
}
// Leetcode 459

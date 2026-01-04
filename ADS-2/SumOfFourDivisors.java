import java.util.HashSet;

public class SumOfFourDivisors {

    public int sumFourDivisors(int[] nums) {
        int res = 0;

        for (int num : nums) {
            // To avoid duplicate divisors (e.g., when i == num / i)
            HashSet<Integer> set = new HashSet<>();

            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    set.add(i);
                    set.add(num / i);
                }
            }

            if (set.size() == 4) {
                int sum = 0;
                for (int val : set) {
                    sum += val;
                }
                res += sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SumOfFourDivisors solution = new SumOfFourDivisors();

        int[] nums = {21, 4, 7};
        int result = solution.sumFourDivisors(nums);

        System.out.println("Sum of divisors of numbers having exactly four divisors: " + result);
    }
}

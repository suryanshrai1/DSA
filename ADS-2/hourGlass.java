
/*
basically in this PS we have to find the remainig time & flip cnt,
the n there are 2 major cases, - one when s is less or eq k and other when not(- then we have 2 cases in this even and odd interval)
at end we gotta return the max of remSnd
*/
import java.util.Scanner;

public class hourGlass {
    private static long helperFn(long s, long k, long m) {
        long remTime = m % k; // how much time passed since last flip
        long n = m / k; // flip cnt
        long snd;

        if (s <= k) {
            // since s is small, every flip casuses reset
            snd = s;
        } else {
            // cap - large- between start with s and start with k
            if (n % 2 == 0) {
                // Even intervals start with s
                snd = s;
            } else {
                // k - odd intervals
                snd = k;
            }
        }
        // calc what remains-sand falls for remTime min
        long remSnd = snd - remTime;
        return Math.max(0, remSnd);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                long s = sc.nextLong();
                long k = sc.nextLong();
                long m = sc.nextLong();
                System.out.println(helperFn(s, k, m));
            }
        }
    }
}
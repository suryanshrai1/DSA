public class eqSumOf2halves {
	long MOD = 1000000007;
	
	public int computeValue(int n) {
		if (n == 0)
			return 1;
		
		long num = factorial(2 * n);
		long den = (factorial(n) * factorial(n)) % MOD;
		
		return (int)((num * power(den, MOD - 2)) % MOD);
	}
	
	private long factorial(int n) {
		long res = 1;
		for (int i = 2; i <= n; i++) {
			res = (res * i) % MOD;
		}
		return res;
	}
	
	private long power(long x, long y) {
		long res = 1;
		x = x % MOD;
		while (y > 0) {
			if (y % 2 == 1) res = (res * x)
				% MOD;
			y = y>> 1;
			x = (x * x) % MOD;
		}
		return res;
	}
}

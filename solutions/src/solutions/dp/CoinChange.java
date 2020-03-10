package solutions.dp;

public class CoinChange {
	public int solve(int[] coins, int amount) {
		return solve(coins, amount, new int[amount+1]); 
	}
	
	private int solve(int[] coins, int amount, int[] cache) {
		if (amount == 0) {
			return 0;
		} else if (amount < 0) {
			return -1;
		}
		
		if (cache[amount] != 0) {
			return cache[amount];
		}
		
		int min = Integer.MAX_VALUE; 
		for (int coin : coins) {
			int n = solve(coins, amount - coin, cache);
			if (n >= 0 && n < min) {
				min = 1 + n;
			}
		}
		
		cache[amount] = min == Integer.MAX_VALUE ? -1 : min;
		return cache[amount];
	}
}

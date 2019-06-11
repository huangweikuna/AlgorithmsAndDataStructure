 package easy;

public class LeetCode121 {
	// 石头的最大利益 那一天买哪一天卖受益最大

	public int maxProfit(int[] prices) {
		if(prices.length == 0)return 0;
		int lowP = prices[0];// 假设第一个数为最小值
		int maxP = 0;// 存储最大受益
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] <= lowP)
				lowP = prices[i];
			maxP = Math.max(maxP, prices[i] - lowP);
		}
		if (maxP <= 0)
			return 0;
		return maxP;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 6, 4, 3, 1 };
		int res = new LeetCode121().maxProfit(arr);
		System.out.println(res);
	}
}

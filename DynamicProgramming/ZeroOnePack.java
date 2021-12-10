
public class ZeroOnePack {

	public static int FindMaxValue(int W, int[] weight, int[] value) {
		
		int n = weight.length - 1;//n为items的个数
		int[] dp = new int[W + 1];//dp[i]表示
		
		for(int i = 1; i <= n; i++) {
			//决定是否往背包里装入第i个item
			
			for(int j = W; j >= weight[i]; j--) {
				//j的终止条件与dp[j - weight[i]]有关
				//根据动态规划bottom-up的思想，要求第i步最优解，我们只需要根据第i-1步最优解来求
				//故从后往前更新！！！
				dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
			}
		}
		return dp[W];
	}
}

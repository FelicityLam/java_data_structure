import java.util.*;

public class MultiPack {

	public static int Multi(int[] w, int[] v, int[] num, int n, int W) {
		
		int[][] f = new int[n + 1][W + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= W; j++) {
				if(w[i] > j)
					f[i][j] = f[i - 1][j];
				else {
					int count = Math.min(num[i], j / w[i]);
					for(int k = 1; k <= count; k++) {
						//k <= num[i] && k * w[i] <= j
						f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - k * w[i]] + k * v[i]);
						//将k个第i种物品pack up >> 看作一个物品 >> 回到01背包
					}
				}
			}
		}
		
		return f[n][W];
	}
	
	
	public static int MultiPromote(int[] w, int[] v, int[] num, int n, int W) {
		
		int[] f = new int[W + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = W; j >= 1; j--) {
				if(w[i] > j)
					f[j] = f[j];
				else {
					int count = Math.min(num[i], j / w[i]);
					for(int k = 1; k <= count; k++)
						f[j] = Math.max(f[j], f[j - k * w[i]] + k * v[i]);
				}
			}
		}
		
		return f[W];
	}
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int W = scan.nextInt();
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		int[] num = new int[n + 1];

		for(int i = 1; i <= n; i++) {
			w[i] = scan.nextInt();
			v[i] = scan.nextInt();
			num[i] = scan.nextInt();
		}
		scan.close();
		
		System.out.println(MultiPromote(w, v, num, n, W));
	}
}

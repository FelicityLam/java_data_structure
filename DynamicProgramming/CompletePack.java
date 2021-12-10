import java.util.*;

public class CompletePack {

	public static int Complete(int[] w, int[] v, int n, int W ) {
		
		int[][] f = new int[n + 1][W + 1];
	
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= W; j++) {
				if(w[i] > j)
					f[i][j] = f[i - 1][j];
				else 
					f[i][j] = Math.max(f[i - 1][j], f[i][j - w[i]] + v[i]);
					//f[i - 1][j]代表第i种物品一个都不放
				 	//f[i][j - w[i]]代表回到上一个状态：少放了一个第i种物品
					//第i次循环——第i种物品的专场
				//上一个状态很重要！！！
			}
		}
		return f[n][W];
	}
	
	public static int CompletePromote(int[] w, int[] v, int n, int W) {
		
		int[] f = new int[W + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= W; j++) {
			//这里用到的是顺序
			
				if(w[i] > j)
					f[j] = f[j];
				else
					f[j] = Math.max(f[j], f[j - w[i]] + v[i]);
			}
		}
		return f[W];
	}
		
	
	public static void main(String[] args) {
		//Test
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int W = scan.nextInt();
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		
		for(int i = 1; i <= n ;i++) {
			w[i] = scan.nextInt();
			v[i] = scan.nextInt();
		}
		scan.close();
		
		System.out.println(CompletePromote(w, v, n, W));
	}
}



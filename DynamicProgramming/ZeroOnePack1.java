import java.util.Scanner;

public class ZeroOnePack1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int W = scan.nextInt();
		int n = scan.nextInt();
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			w[i] = scan.nextInt();
			v[i] = scan.nextInt();
		}
		scan.close();
		
		int[][] c = new int[n + 1][W + 1];
		//c[i][j]表示当前背包最大容量为j，前i个物品的最佳组合对应的总MaxValue
		
		//填表
		int i, j;
		for(i = 1; i <= n; i++) {
			for(j = 1; j <= W; j++) {
				if(w[i] <= j)
					//还有足够的容量可以装该商品（装了该商品可能要舍弃其他的，会使c的值变化），装了也不一定达到当前最优价值，所以在装与不装之间选择最优的一个
					c[i][j] = Math.max(c[i - 1][j - w[i]] + v[i], c[i - 1][j]);
					//c[i - 1][j - w[i]]代表上一个状态：不放第i件物品
				else
					//包的容量比该商品体积小，装不下
					c[i][j] = c[i - 1][j];
			}
		}
		System.out.println(c[n][W]);
		
		
		//空间优化
		//观察转移方程，求c[i][j]只需要用到c[i - 1][j]或者c[i - 1][j - w[i]]
		//省去一维空间，用i的循环代替，即第i - 1次循环中c[j]代表c[i - 1][j]
		//
		for(i = 1; i <= n; i++) {
			for(j = W; j >= 0; j--) {   //eg: 第i次循环时，c[3]值的确定需要比较第i - 1次循环得出的c[3]和c[1]; 若从前往后更新，到c[3]时c[1]已经被更新为第i次循环的
				
				//原来的转移方程: j >= w[i]时, c[i][j] = max(c[i - 1][j], c[i - 1][j - w[i]] + v[i]
				if(j >= w[i]) {
					//保证左边指的是c[i][j]，右边指的是c[i - 1][j]
					c[j] = Math.max(c[j], c[j - w[i]] + v[i]);
				}
				
				//原来的转移方程: j < w[i]时, c[i][j] = c[i - 1][j]
				else
					c[j] = c[j];
			}
		}
		
		
		
		
		
		//最优解回溯
		//找出最优解的组成
		int p = n;
		int q = W;
		while(p > 0 && q > 0) {
			if(c[p][q] == c[p - 1][q]) {
				p = p - 1;
			}
			else {
				System.out.println(p);
				q = q - w[p];
				p = p - 1;

			}
		}
	}
}

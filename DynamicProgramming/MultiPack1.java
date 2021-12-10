import java.util.*;

public class MultiPack1 {

	public static int Multi(int W, int V, int n, int[] w, int[] v, int[] p, int[] num) {
		
		int[][] f = new int[W + 1][V + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = W; j >= 1; j--) {
				for(int k = V; k >= 1; k--) {
					
					int count = Math.min(num[i], j / w[i]);
					int count1 = Math.min(count, k / v[i]);
					
					for(int m = 1; m <= count1; m++) {
						if(w[i] > j || v[i] > k)
							f[j][k] = f[j][k];
						else 
							f[j][k] = Math.max(f[j][k], f[j - m * w[i]][k - m * v[i]] + m * p[i]);
					
					}
				}
			}
		}
		
		return f[W][V];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int W = scan.nextInt();
		int V = scan.nextInt();
		int n = scan.nextInt();
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		int[] p = new int[n + 1];
		int[] num = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			w[i] = scan.nextInt();
			v[i] = scan.nextInt();
			p[i] = scan.nextInt();
			num[i] = scan.nextInt();
		}
		scan.close();
		
		System.out.println(Multi(W, V, n, w, v, p, num));
	}
}
	

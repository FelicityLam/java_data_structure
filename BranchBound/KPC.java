import java.util.*;

public class KPC {

	/*
	 * Knapsack Problem with Conflicts
	 * 0-1背包问题：有N件物品和一个容量为Q的背包。第i件物品的价值是pi，重量是wi。求解将哪些物品装入背包可使价值总和最大；
	 * 冲突约束：某些物品存在冲突，例如物品i和物品j存在冲突，这不能同时将物品i和物品j装入背包；
	 * 我们利用一个图来表示冲突（Conflict Graph），图上的每个节点代表每一个物品，假如两个物品之间存在冲突，则在图上对应的两个节点连一条边。
	 * 
	 */
	
	public int best_profit;
	public int best_weight;
	public ArrayList<Integer> best_sol;
	
	public int[][] bound;
	
	public void dfs(int n, int[] w, int[] p, boolean[][] conf, int Q, int st, ArrayList<Integer> sol, int sw, int sp) {
		if(st < n - 1 && sp + bound[st + 1][Q - sw] <= best_profit)
			return;
		
		if(sp > best_profit) {
			best_profit = sp;
			best_weight = sw;
			best_sol = new ArrayList<Integer>(sol);
		}
		
		for(int i = st + 1; i < n; i++) {
			if(sw + w[i] > Q)
				continue;
			
			boolean is_conf = false;
			for(int j = 0; j < sol.size(); j++) {
				int a = sol.get(j);
				if(conf[i][a]) {
					is_conf = true;
					break;
				}
			}
			if(is_conf)
				continue;
			
			sol.add(i);
			dfs(n, w, p, conf, Q, i, sol, sw + w[i], sp + p[i]);
			sol.remove(sol.size() - 1);
		}
	}
	
	
	public void compute_bound(int n, int[] w, int[] p, int Q) {
		for(int i = 1; i <= Q; i++) {
			if(i < w[n - 1])
				bound[n - 1][i] = 0;
			else
				bound[n - 1][i] = p[n - 1];
		}
		
		for(int i = n - 2; i >= 0; i--) {
			for(int j = 1; j <= Q; j++) {
				if(j < w[i])
					bound[i][j] = bound[i + 1][j];
				else 
					bound[i][j] = Math.max(bound[i + 1][j], bound[i + 1][j - w[i]] + p[i]);
			}
		}
	}
}

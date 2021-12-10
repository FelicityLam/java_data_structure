import java.util.*;

public class Balence {

	/*
	 * 有 N 堆纸牌，编号分别为 1，2，…, N。每堆上有若干张，但纸牌总数必为 N 的倍数。
	 * 可以在任一堆上取若于张纸牌，然后移动。
	 * 移牌规则为：在编号为 1 堆上取的纸牌，只能移到编号为 2 的堆上；
	 * 在编号为 N 的堆上取的纸牌，只能移到编号为 N-1 的堆上；其他堆上取的纸牌，可以移到相邻左边或右边的堆上。
	 * 现在要求找出一种移动方法，用最少的移动次数使每堆上纸牌数都一样多。
	 * 
	 */
	
	public static class Opt{
		public int from;
		
		public int to;
		
		public int amount;
		
		public Opt(int from, int to, int amount) {
			this.from = from;
			this.to = to;
			this.amount = amount;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {9, 8, 12, 6};
		int[] b = new int[a.length];
		int sum = 0;
		for(int i = 0; i < a.length; i++) {
			b[i] = a[i];
			sum += a[i];
		}
		int avg = sum / a.length;
		
		int n = 0;
		ArrayList<Opt> opts = new ArrayList<Opt>();
		for(int i = 0; i < b.length; i++) {
			if(b[i] != avg) {
				n++;
				if(b[i] < avg) {
					opts.add(new Opt(i + 1, i, avg - b[i]));
				}
				else {
					opts.add(new Opt(i, i + 1, b[i] - avg));
				}
			}
			
			if(i < b.length - 1)
				b[i + 1] += b[i] - avg;
		}
		System.out.println(n);
	}
}

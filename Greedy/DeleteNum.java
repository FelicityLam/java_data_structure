import java.util.*;

public class DeleteNum {

	/*
	 * 给定n位正整数a，去掉其中任意k个数字后，剩下的数字按原次序排列组成一个新的正整数。
	 * 对于给定的n和k，设计一个算法，找出剩下数字组成的新数最小的删数方案。
	 * 
	 */
	
	
	/*
	 * 按照高位到低位的顺序搜索，若各位数字递增，则删除最后一个数字；
	 * 否则删除第一个递减区间的首字符，然后回到串首，再重复删除。
	 * 
	 */
	
	public static void main(String[] args) {
		int n = 178543;
		int k = 4;
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		int b = n;
		while(b != 0) {
			a.add(0, b % 10);
			b /= 10;
		}
		
		for(int i = 0; i < k; i++) {
			int p = 0;
			while(p < a.size() - 1 && a.get(p) <= a.get(p + 1))
				p++;
			a.remove(p);
		}
		
		String str = "";
		for(int i = 0; i < a.size(); i++)
			str += a.get(i);
		System.out.println(str);
	}
}

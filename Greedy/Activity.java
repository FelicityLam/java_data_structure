import java.util.*;

public class Activity {

	/*
	 * 有n个需要在同一天使用同一个教室的活动a1,a2,…,an，教室同一时刻只能由一个活动使用。
	 * 每个活动ai都有一个开始时间si和结束时间fi 。
	 * 一旦被选择后，活动ai就占据半开时间区间[si,fi)。如果[si,fi]和[sj,fj]互不重叠，ai和aj两个活动就可以被安排在这一天。
	 * 求同一天可以在这个教室开展活动的最大数量。
	 * 
	 */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] start = new int[n];
		int[] finish = new int[n];
		for(int i = 0; i < n; i++) {
			start[i] = scan.nextInt();
			finish[i] = scan.nextInt();
		}
		scan.close();
		
		//按结束时间从早到晚排序
		for(int i = 0; i < n - 1; i++) {
			int min_index = i;
			for(int j = i + 1; j < n; j++) {
				if(finish[j] < finish[min_index])
					min_index = j;
			}
			if(min_index != i) {
				int temp1 = start[i];
				start[i] = start[min_index];
				start[min_index] = temp1;
				
				int temp2 = finish[i];
				finish[i] = finish[min_index];
				finish[min_index] = temp2;
			}
		}
		
		
		int pre = 0;
		int count = 1;
		int cur = 1;
		for(cur = 1; cur < n; cur ++) {
			if(start[cur] >= finish[pre]) {
				count ++;
				pre = cur;
			}
		}
		
		System.out.println(count);
	}
}

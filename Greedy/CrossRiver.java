import java.util.*;

public class CrossRiver {

	/*
	 * 现在有n个人需要过河，只有一艘船，最多能乘2人，船的运行速度为2人中较慢一人的速度，
	 * 过去后还需一个人把船划回来，问把n个人运到对岸，最少需要多久
	 * 
	 */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] time = new int[n];
		for(int i = 0; i < n; i++)
			time[i] = scan.nextInt();
		scan.close();
		
		for(int i = 0; i < n - 1; i++) {
			int min_index = i;
			for(int j = i + 1; j < n; j++) {
				if(time[j] < time[min_index])
					min_index = i;
			}
			if(min_index != i) {
				int temp = time[i];
				time[i] = time[min_index];
				time[min_index] = temp;
			}
		}
		
		int sum = 0;
		while(n > 3) {
			sum += Math.min(time[1] * 2 + time[0] + time[n - 1], time[n - 1] + time[0] * 2 + time[n - 2]);
			n -= 2;
		}
		
		if(n == 1)
			sum += time[0];
		else if(n == 2)
			sum += time[1];
		else if(n == 3)
			sum += time[1] + time[0] + time[2];
		
		System.out.println(sum);
	}
}

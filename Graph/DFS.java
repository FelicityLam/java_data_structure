import java.util.*;

public class DFS {

	/*递归*/
	public static boolean dfs(int[][] map, int s, int t, ArrayList<Integer> path, boolean[] visited) {
		path.add(s);
		visited[s] = true;
		
		if(s == t)
			return true;	//递归终止条件
		
		for(int i = 0; i < map[s].length; i++) {
			if(map[s][i] == 1 && visited[i] == false) {
				if(dfs(map, i, t, path, visited))
					return true;
			}
		}
		path.remove(path.size() - 1);	//回撤
		return false;
	}
	
	/*用到队列*/ 
	public static ArrayList<Integer> bfs(int[][] map, int s, int d){
		ArrayList<Integer> path = new ArrayList<Integer>();
		ArrayList<Integer> queue = new ArrayList<Integer>();
		int[] pre = new int[map.length];
		
		/*初始化pre的值*/
		for(int i = 0; i < pre.length; i++)
			pre[i] = -1;
		
		queue.add(s);
		while(queue.isEmpty() == false) {
			int a = queue.get(0);
			queue.remove(0);
			
			/*终止条件*/
			if(a == d) {
				int temp = d;
				while(temp >= 0) {
					path.add(0, temp);
					temp = pre[temp];
				}
				return path;
			}
			
			for(int i = 0; i < map[a].length; i++) {
				if(map[a][i] == 1 && pre[i] < 0) {
					queue.add(i);
					pre[i] = a;
				}
			}
		}
		
		return path;
	}
	
	/*连通图中，给出起点，遍历整个图*/
	public static void dfs1(int[][] map, int s, boolean[] visited) {
		System.out.print(s + " ");
		visited[s] = true;
		
		for(int i = 0; i < map[s].length; i++) {
			if(visited[i] == false && map[s][i] == 1) {
				System.out.print(i + " ");
				dfs1(map, i, visited);
			}
		}
	}
	
	
	public static void bfs1(int[][] map, int s) {
		ArrayList<Integer> queue = new ArrayList<Integer>();
		boolean[] visited = new boolean[map.length];
		
		queue.add(s);
		visited[s] = true;
		System.out.print(s + " ");
		
		while(queue.isEmpty() == false) {
			int a = queue.get(0);
			queue.remove(0);
			System.out.print(a + " ");
			
			for(int i = 0; i < map[a].length; i++) {
				if(visited[i] == false && map[a][i] == 1) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] map = new int[n][n];
		int[] v1 = new int[m];
		int[] v2 = new int[m];
		for(int i = 0; i < m; i++) {
			v1[i] = scan.nextInt();
			v2[i] = scan.nextInt();
		}
		for(int i = 0; i < m; i++) {
			map[v1[i]][v2[i]] = 1;
			map[v2[i]][v1[i]] = 1;
		}
		scan.close();
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		boolean[] visited = new boolean[n];
		if(dfs(map, 0, n - 1, path, visited)) {
			System.out.println(path);
		}
		System.out.println(bfs(map, 0, n - 1));
	}
}

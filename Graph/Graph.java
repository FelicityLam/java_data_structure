import java.util.*;

public class Graph {

	/*连通图dfs*/
	public static void dfs(int[][] graph, int id, boolean[] visited) {
		System.out.print(id + " ");
		visited[id] = true;
		for(int i = 0; i < graph[id].length; i++) {
			if(graph[id][i] == 1 && visited[i] == false) {
				dfs(graph, i, visited);
			}
		}
	}
	
	/*连通图bfs*/
	public static void bfs(int[][] graph, int id) {
		ArrayList<Integer> queue = new ArrayList<Integer>();
		boolean[] visited = new boolean[graph.length];
		queue.add(id);
		visited[id] = true;
		
		while(queue.isEmpty() == false) {
			int head = queue.get(0);
			queue.remove(0);
			System.out.print(head + " ");
			
			for(int i = 0; i < graph[head].length; i++) {
				if(graph[head][i] == 1 && visited[i] == false) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	
}

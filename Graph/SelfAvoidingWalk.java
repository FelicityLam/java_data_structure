
public class SelfAvoidingWalk {

	public static void SAW(int n, int trail) {
		boolean[][] visited = new boolean[n][n];
		int deadEnd = 0;
		for(int i = 0; i < trail; i++) {
			int x = n / 2;
			int y = n / 2;
			
			while(x > 0 && x < n - 1 && y > 0 && y < n - 1) {	//边界
				//终止条件
				if(visited[x - 1][y] == false && visited[x + 1][y] == false && visited[x][y + 1] == false && visited[x][y - 1] == false) {
					deadEnd ++;
					break;
				}
				
				visited[x][y] = true;
				
				double pro = Math.random();
				
				if(pro < 0.25 && visited[x - 1][y] == false)
					x--;
				else if(pro < 0.5 && visited[x + 1][y] == false)
					x++;
				else if(pro < 0.75 && visited[x][y + 1] == false)
					y++;
				else if(pro < 1 && visited[x][y - 1] == false)
					y--;
			}
		}
		
		System.out.println(deadEnd / trail);
	}
}

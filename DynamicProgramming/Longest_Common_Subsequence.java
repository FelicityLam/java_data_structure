
public class Longest_Common_Subsequence {
 
	//返回最长子串的长度
	public static int lcs(String a, String b) {
		int len_a = a.length();
		int len_b = b.length();
		int[][] len = new int[len_a + 1][len_b + 1];
		
		int i;
		int j;
		for(i = 1; i <= len_a; i++) {
			for(j = 1; j <= len_b; j++) {
				if(a.charAt(i - 1) == b.charAt(j - 1))
					len[i][j] = len[i - 1][j - 1] + 1;
				else
					len[i][j] = Math.max(len[i - 1][j], len[i][j - 1]);
			}
		}
		return len[len_a][len_b];
	}
	
	
	//输出最长子串
	//最优解（动态规划）回溯
	public static void LCS(String a, String b) {
		int len_a = a.length();
		int len_b = b.length();
		int[][] len = new int[len_a + 1][len_b + 1];
		
		int i;
		int j;
		for(i = 1; i <= len_a; i++) {
			for(j = 1; j <= len_b; j++) {
				if(a.charAt(i - 1) == b.charAt(j - 1))
					len[i][j] = len[i - 1][j - 1] + 1;
				else
					len[i][j] = Math.max(len[i - 1][j], len[i][j - 1]);
			}
		}
		
		int p = len_a;
		int q = len_b;
		String ret = "";
		while(p > 0 && q > 0) {
			if(len[p][q] == len[p - 1][q - 1] + 1) {
				//a串中第p个元素与b串中第q个元素相同，即a[p - 1] == b[q - 1]
				ret = a.charAt(p - 1) + ret;
				p = p - 1;
				q = q - 1;
			}
			else if(len[p][q] == len[p - 1][q]) {
				p = p - 1;
			}
			else
				q = q - 1;
		}
		System.out.println(ret);
	}
	
	public static void main(String[] args) {
		System.out.println(lcs("GGCACCACG", "ACGGCGGATACG"));
		LCS("GGCACCACG", "ACGGCGGATACG");
	}
}


public class kmp {

	public static int kmp(String s, String t) {
		int[] next = get_nextval(t);
		int i = 0;
		int j = 0;
		
		while(i < s.length() && j < t.length()) {
			if(j == 0 || s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			}
			else
				j = next[j];
		}
		if(j >= t.length())
			return i - t.length();
		else
			return -1;
	}
	
}

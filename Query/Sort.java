
public class Sort {

	/*直接插入排序（基于顺序查找）*/
	public static void insertSort(int[] a) {
		int i;
		int j;
		for(i = 1; i < a.length; i++) {
			a[0] = a[i];
			for(j = i - 1; a[0] < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j] = a[0];
		}
	}
	
	public static void bubbleSort(int[] a, int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				if(a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
}

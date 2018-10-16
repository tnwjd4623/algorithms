

public class binaryinsertionSort {
	private int number[];
	int size = 0;
	
	public binaryinsertionSort(int[] array, int size) {
		number = array;
		this.size = size;
	}
	
	/* insertion sort with Binary Search */
	public void binary_insertion_sort() {
		int index = 0;
		
		for(int i = 1; i<size; i++) {
			int tmp = number[i];
			int j = 0;
			/*Binary Search*/
			int mid;
			int left = 0;
			int right = i-1;
			
			while(right >= left) {
				mid = (right+left) / 2;
				if(number[mid] == tmp ){
					index = mid;
					break;
				}
				else if(number[mid] < tmp) {
					left = mid+1;
				}
				else {
					right = mid-1;
				}
				
				index = left;
			}
			/*Sorting*/
			for(j = i-1; j>=index; j--) {
				number[j+1] = number[j];
			}
			number[j+1] = tmp;
			
			
		}
	}


}

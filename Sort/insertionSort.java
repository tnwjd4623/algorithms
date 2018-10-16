

public class insertionSort {
	private int number[];
	int size = 0;
	
	public insertionSort(int[] array, int size) {
		number = array;
		this.size = size;
	}
	/*insertion sort with no Binary Search*/
	public void insertion_sort() {
		for(int i = 1; i<size; i++) {
			int tmp = number[i];
			int j=0;
			for(j = i-1; j>=0; j--) {
				if(number[j] < tmp) 
					break;
				
				else 
					number[j+1]  = number[j];
			}	
				number[j+1] = tmp;
		}
	}
	
}

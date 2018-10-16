package hw01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class mergeSort {

	private int number[];
	int size = 0;
	
	public mergeSort(int[] array, int size) {
		number = array;
		this.size = size;
	}
	/* merge sort */
	public void merge_sort(int left, int right) {
		int mid;
		if(left < right) {
			mid = left + ((right-left) / 2);
			merge_sort(left, mid);
			merge_sort(mid+1, right);
			merge(left, right);
		}
	}
	/* merge */
	public void merge(int left, int right) {
		int arr[] = new int[size];
		int mid = left +((right-left) / 2);
		int index = left;
		int i, j;
		
		for(i=left, j = mid+1;i<=mid&&j<=right;) {
			if(number[i] < number[j])
				arr[index++] = number[i++];
			else
				arr[index++] = number[j++];
		}
		
		while(i<=mid) {
			arr[index++] = number[i++];
		}
		while(j<=right) {
			arr[index++] = number[j++];
		}
		
		for(int k = left; k< index; k++) {
			number[k] = arr[k];
		}
		
	}
	public void printArray() {
		System.out.print("[");
		for(int i = 0; i<size-1; i++) {
			System.out.print(number[i]+", ");
		}
		System.out.println(number[size-1]+" ]");
	}
	
	public void printFile(File file) throws IOException{
		FileWriter fw = new FileWriter(file);
		for(int i = 0; i<size-1; i++) {
			fw.write(number[i]+",");
		}
		fw.write(number[size-1]+"");
		fw.close();
	}
}

package hw01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

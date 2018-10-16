package hw01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class threewaymergeSort {
	private int number[];
	int size = 0;
	
	public threewaymergeSort(int[] array, int size) {
		number = array;
		this.size = size;
	}
	/* 3 way merge sort */
	public void threeWay_merge_sort(int left, int right) {
		int sublist;
		int sublist2;
		
		if(right-left <= 1) {
			merge_sort(left, right);
		}
		
		else if(right-left > 1) {
			sublist = left+((right-left) / 3);
			sublist2 =(right-left)/3*2 + 1 + left;
			
			threeWay_merge_sort(left, sublist);
			threeWay_merge_sort(sublist+1, sublist2);
			threeWay_merge_sort(sublist2+1, right);
			threeWay_merge(left, right);
		}
		
	}
	/* 3 way merge */
	public void threeWay_merge(int left, int right) {
		int arr[] = new int[size];
		int sublist = left + ((right-left) / 3);
		int sublist2 = (right-left)/3*2 + 1 + left;
		int index = left;
		
		int i = left;
		int j = sublist+1;
		int k = sublist2+1;
		
		while(i<=sublist&&j<=sublist2&&k<=right) {
			if(number[i] < number[j]){
				if(number[i] < number[k]){
					arr[index++] = number[i++];
				}
				else{
					arr[index++] = number[k++];
				}
				continue;
			}
			if(number[k] < number[j]){
				if(number[k] < number[i]){
					arr[index++] = number[k++];
				}
				else{
					arr[index++] = number[i++];
				}
				continue;
			}
			else
				arr[index++] = number[j++];			
		}
		while(i<=sublist&&j<=sublist2) {
			if(number[i] < number[j])
				arr[index++] = number[i++];
			else
				arr[index++] = number[j++];
		}
		while(i<=sublist&&k<=right) {
			if(number[i] < number[k])
				arr[index++] = number[i++];
			else
				arr[index++] = number[k++];
		}
		while(j<=sublist2&&k<=right) {
			if(number[j] < number[k])
				arr[index++] = number[j++];
			else
				arr[index++] = number[k++];
		}
		
		while(i<=sublist) {
			arr[index++] = number[i++];
		}
		while(j<=sublist2) {
			arr[index++] = number[j++];
		}
		while(k<=right) {
			arr[index++] = number[k++];
		}
		
		for(int l = left; l< index; l++) {
			number[l] = arr[l];
		}
		
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

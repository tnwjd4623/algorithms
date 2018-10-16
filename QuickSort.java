package hw03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class QuickSort {
	private int[] array = new int[1000000];
	int size = 0;

	public QuickSort(int[] a, int size) {
		array = a;
		this.size = size;
	}
	
	//partition
	public int partition(int p, int r) {
		int x = array[r];
		int i = p-1;
		
		for(int j = p; j<=r-1; j++) {
			if(array[j]<=x) {
				i = i+1;
				int tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
			}
		}
		i = i+1;
		int tmp = array[i];
		array[i] = array[r];
		array[r] = tmp;
		
		return i;
	}
	
	//random partition
	public int randomizedPartition(int p, int r) {
		Random random = new Random();
		int i = random.nextInt(r-p+1)+p;
		int tmp = array[i];
		
		array[i] = array[r];
		array[r] = tmp;
		
		return partition(p, r);
	}
	
	//quicksort
	public void quickSort(int p, int r) {
		if(p<r) {
			int q = partition( p, r);
			quickSort(p, q-1);
			quickSort(q+1, r);
		}
	}
	
	//random quicksort
	public void quickSort_withRandom(int p, int r) {
		if(p<r) {
			int q = randomizedPartition(p, r);
			quickSort_withRandom(p, q-1);
			quickSort_withRandom(q+1, r);
		}
	}
	
}

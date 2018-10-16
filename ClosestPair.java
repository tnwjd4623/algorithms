package hw04;

import java.util.Arrays;

public class ClosestPair {
	private _Point array[];
	private int size = 0;
	
	private class _Point implements Comparable<_Point>{
		private double x;
		private double y;
		
		public _Point(double X, double Y) {
			this.x = X;
			this.y = Y;
		}
		public int compareTo(_Point p) {
			if(this.x < p.x)
				return -1;
			else if(this.x == p.x) {
				return 0;
			}
			else 
				return 1;
		}
		public String toString() {
			return x+" "+y;
		}
	}
	public ClosestPair(double X[], double Y[], int size){
		this.size = size;
		array = new _Point[size];
		
		for(int i = 0; i<size; i++) {
			array[i] = new _Point(X[i], Y[i]);
		}
	}
	public void do_ClosestPair() {
		Arrays.sort(array);
		int L = size/2;
		
		double left = find_Min(0, L);
		double right = find_Min(L, size-1);
		double min = 0;
		double win = 0;
		
		if(left > right)
			min = right;
		else
			min = left;
		
		win = window_Min(min);
		
		if(win>min)
			System.out.println(Math.sqrt(min));
		else
			System.out.println(Math.sqrt(win));
		
	}
	
	/*범위 내의 점 사이에서 최소 값 구하기*/
	private double find_Min(int first, int last) {
		double min = 10000000;
		
		if(first==last) {
			return min;
		}
		
		for(int i = first+1; i<=last; i++) {
			double x_tmp = Math.pow(array[first].x - array[i].x, 2); 
			double y_tmp = Math.pow(array[first].y - array[i].y, 2);
			
			if(min > (x_tmp+y_tmp) ) {
				min = x_tmp + y_tmp;
			}
		}
		
		double tmp = find_Min(first+1, last);
		if(min > tmp)
			min = tmp;
		
		return min;
	}
	
	/*window 씌움*/
	private double window_Min(double d) {
		int L = size/2;
		int i, j;
		for(i=L-1; i>=0; i--) {
			double x_tmp = Math.pow(array[L].x - array[i].x, 2); 
			double y_tmp = Math.pow(array[L].y - array[i].y, 2);
			
			if(d < (x_tmp + y_tmp))
				break;
		}
		
		for(j=L+1; j<size; j++) {
			double x_tmp = Math.pow(array[L].x - array[j].x, 2); 
			double y_tmp = Math.pow(array[L].y - array[j].y, 2);
			
			if(d < (x_tmp + y_tmp))
				break;
		}
		
		double min = find_Min(i, j);
		
		return min;
	}
}

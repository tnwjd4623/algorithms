package hw12;

import java.util.ArrayList;

public class Sequence_alignment {
	private int[][] a;
	private Path[][] path;	//0: none & | 1: i=i&j=j | 2:i=i&j="-" | 3:i="-"&j=j 
	private int lx, ly;
	private int q = -2;
	private String x, y;
	private String[] result1, result2;
	private int index = 0;
	
	class Path {
		ArrayList<Integer> path;
		public Path() {
			path = new ArrayList<Integer>();
		}
	}
	public Sequence_alignment(String s1, String s2) {
		result1 = new String[10000];
		result2 = new String[10000];
		for(int i = 0; i<10000; i++) {
			result1[i] = "";
			result2[i] = "";
		}
		if(s1.length()>s2.length()) {
			lx = s2.length();
			ly = s1.length();
			this.x = s2;
			this.y = s1;
		}
		else {
			lx = s1.length();
			ly = s2.length();
			this.x = s1;
			this.y = s2;
		}
		
		a = new int[lx+1][ly+1];
		path = new Path[lx+1][ly+1];	
		
		for(int i = 0; i<=lx; i++) {
			for(int j = 0; j<=ly; j++) {
				path[i][j] = new Path();
			}
		}
	}
	
	public void Seqence_alignment() {
		for(int i = 0; i<=lx; i++) {
			a[i][0] = i*q;
		}
		
		for(int j = 0; j<=ly; j++) {
			a[0][j] = j*q;
		}
		
		for(int j=1; j<=ly; j++) {
			for(int i = 1; i<=lx; i++) {
				a[i][j] = max(a[i][j-1]+q, a[i-1][j-1]+p(i,j), a[i-1][j]+q);
				
				if(a[i][j] == a[i][j-1]+q) {
					path[i][j].path.add(2);
				}
				if(a[i][j] == a[i-1][j-1]+p(i,j)) {
					path[i][j].path.add(1);
				}
				if(a[i][j] == a[i-1][j]+q) {
					path[i][j].path.add(3);
				}
			}
		
		}
		printArray();
		int max = -99999;
		int max_index = 0;
		
		for(int k = 1; k<=lx; k++) {
			if(max < a[k][ly]){
				max = a[k][ly];
				max_index = k;
			}
		}
		Align(ly-1, max_index, ly, index);
		printAlign();
		
	}
	
	public void printArray() {
		for(int i = 0; i<=lx; i++) {
			for(int j = 0; j<=ly; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println("");
		}
	}
	public int p(int i, int j) {
		if(x.charAt(i-1) == y.charAt(j-1)){
			return 1;
		}
		else
			return -1;
	}
	public int max(int a, int b, int c) {
		int max = (a>b) ? a:b;
		max = (max>c)? max:c;
		
		return max;
	}
	public int Align(int count, int i, int j, int index) {
		int max = -999999;
		
		while(count>=0) {
			if(path[i][j].path.size()<2) {
				if(path[i][j].path.get(0)==1) {
					result1[index] = y.charAt(j-1)+result1[index];
					result2[index] = x.charAt(i-1) + result2[index];
					i = i-1; j = j-1;
				}
				else if(path[i][j].path.get(0)==2) {
					result1[index] = y.charAt(j-1)+result1[index];
					result2[index] = "-"+result2[index];
					j = j-1;
				}
				else if(path[i][j].path.get(0)==3) {
					result1[index] = "-"+result1[index];
					result2[index] = x.charAt(i-1) + result2[index];
					i = i-1;
				}
			}
			else {
				String result1_tmp = result1[index];
				String result2_tmp = result2[index];
				
				if(path[i][j].path.get(0)==1) {
					result1[index] = y.charAt(j-1)+result1[index];
					result2[index] = x.charAt(i-1) + result2[index];
					Align(count-1, i-1, j-1, index);
				}
				else if(path[i][j].path.get(0)==2) {
					result1[index] = y.charAt(j-1)+result1[index];
					result2[index] = "-"+result2[index];
					Align(count-1, i, j-1, index);
				}
				else if(path[i][j].path.get(0)==3) {
					result1[index] = "-"+result1[index];
					result2[index] = x.charAt(i-1) + result2[index];
					Align(count-1, i-1, j, index);
				}
				index++;
				this.index++;
				if(path[i][j].path.get(1)==1) {
					result1[index] = y.charAt(j-1)+result1_tmp;
					result2[index] = x.charAt(i-1) + result2_tmp;
					Align(count-1, i-1, j-1, index);
				}
				else if(path[i][j].path.get(1)==2) {
					result1[index] = y.charAt(j-1)+result1_tmp;
					result2[index] = "-"+result2_tmp;
					Align(count-1, i, j-1, index);
				}
				else if(path[i][j].path.get(1)==3) {
					result1[index] = "-"+result1_tmp;
					result2[index] = x.charAt(i-1) + result2_tmp;
					Align(count-1, i-1, j, index);
				}
				break;
				
			}
			count--;
		}
		
		return max;
	}
	public void printAlign() {
		int max = -99999;
		
		for(int i = 0; i<=index; i++) {
			int tmp = 0;
			for(int k = 0; k<result1[i].length(); k++) {
				if(result1[i].charAt(k)!='-'&&result2[i].charAt(k)!='-') {
					if(result1[i].charAt(k) == result2[i].charAt(k)) 
						tmp = tmp+1;
					else 
						tmp = tmp-1;
				}
				else {
					if(result1[i].charAt(k)=='-' && result2[i].charAt(k)=='-');
					else {
						tmp = tmp-2;
					}
				}
			}
			if(tmp>max) max = tmp;
			System.out.println("경로:"+(i+1)+"\t"+result1[i]+"\t점수: "+max+"\n\t"+result2[i]);
		}
	}

}

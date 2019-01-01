package hw13;

import java.util.ArrayList;

public class Matrix_Chain_Multiplication {
	private String optimal_sol = "";
	private int[][] m;
	private int[][] s;
	private ArrayList<Integer> p = new ArrayList<Integer>();
	
	public Matrix_Chain_Multiplication() {
	}
	public void addFirst(int p, int q) {
		this.p.add(p);
		this.p.add(q);
		
	}
	public void addMatrix(int p) {
		this.p.add(p);
	}
	
	public void Matrix_Chain_Order() {
		
		m = new int[p.size()][p.size()];
		s = new int[p.size()][p.size()];
		for(int i = 0; i<p.size(); i++) {
			for(int j = 0; j<p.size(); j++) {
				m[i][j] = -1;
				s[i][j] = -1;
			}
		}
		int n = p.size()-1;
		
		for(int i = 1; i<=n; i++) {
			m[i][i] = 0;
		}
		for(int l = 2; l<=n; l++) {
			for(int i = 1; i<=n-l+1; i++) {
				int j = i+l-1;
				m[i][j] =9999999;
				
				for(int k = i; k<=j-1; k++) {
					int q = m[i][k] + m[k+1][j] + p.get(i-1)*p.get(k)*p.get(j);
					if(q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
	}
	
	public void Print_Optimal_Parens(int i, int j) {	
		if(i==j){
			System.out.print("A"+i);
			optimal_sol += i+"";
		}
		else {
			System.out.print("(");
			Print_Optimal_Parens(i, s[i][j]);
			Print_Optimal_Parens(s[i][j]+1, j);
			System.out.print(")");
		}
	}
	public void printMArray() {	
		for(int i = 1; i<p.size(); i++) {
			for(int j = 1; j<p.size(); j++) {
				System.out.print(m[i][j]+"\t");
			}
			System.out.println("");
		}
	}
	public void printSArray() {	
		for(int i = 1; i<p.size(); i++) {
			for(int j = 1; j<p.size(); j++) {
				System.out.print(s[i][j]+"\t");
			}
			System.out.println("");
		}
	}
	public void printOptimalSolution() {
		System.out.println("Optimal solution : "+m[1][p.size()-1]);
	}
}

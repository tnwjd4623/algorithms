package hw05;

public class Fibo {
	private long f[];
	private long matrix[][];
	
	public Fibo() {
		f = new long[1000000];
		f[0] = 0;
		f[1] = 1;
		
		matrix = new long[][]{{1L, 1L}, {1L, 0}};
	}
	
	
	public long fibo_Recursion(long n) {
		if(n<2)
			return n;
		
		return fibo_Recursion(n-1) + fibo_Recursion(n-2);
	}
	
	//fibonacci with array
	public long fibo_Array(int n) {
		if(n>1&&f[n]==0) {
			f[n] = fibo_Array(n-1) + fibo_Array(n-2);
		}
		
		return f[n];
	}
	
	//fibonacci with divide and conquer
	public long fibo_RecursiveSquaring(int n) {
		if(n<2)
			return n;
		
		return pow(matrix, n)[0][1];
	}
	private long[][] pow(long[][] A, int n) {
		
		if(n>1) {
			A = pow(A, n/2);
			A = mul(A, A);
			
			if(n%2==1) {
				A = mul(A, matrix);
			}
		}
		
		return A;
	}
	
	private long[][] mul(long[][] A, long[][] B) {
		long result[][] = new long[2][2];
		
		result[0][0] = A[0][0]*B[0][0] + A[0][1]*B[1][0];
		result[0][1] = A[0][0]*B[0][1] + A[0][1]*B[1][1];
		result[1][0] = A[1][0]*B[0][0] + A[1][1]*B[1][0];
		result[1][1] = A[1][0]*B[0][1] + A[1][1]*B[1][1];
		
		return result;
	}
	

}

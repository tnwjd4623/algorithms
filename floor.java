package hw04;

public class floor {
	private long N;
	
	public floor(long n) {
		this.N = n;
	}
	
	public int no_binarySearch() {
		int e = -1;
		long k = 1;
		
		while(k<=N) {
			e = e+1;
			k = k*2;
		}
		return e;
	}
	
	public int with_binarySearch() {
		
		int e = 0;
		long k = 2L;
		
		while(k<=N) {
			if(e == 0)
				e = 1;
			else
				e = e+e;
			
			k = (long)Math.pow(k, 2);
		
		}	
		
		int first = e;
		int last = e+e;
		
		while(first <= last) {
			int mid = (first + last)/2;
			e = mid;
			
			if(last==mid || first==mid) {
				break;
			}
			if(N < Math.pow(2, mid)) {
				last = mid;
			}
			else if(N > Math.pow(2, mid)) {
				first = mid;
			}
			
		}
		
		return e;
	}

}

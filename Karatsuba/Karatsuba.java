package hw06;


public class Karatsuba {
	private int threshold;
	
	public Karatsuba() {
		this.threshold = 3;
	}
	public long mul(long x, long y) {
		int n = getThreshold(x);		//x¿Í yÀÇ ÀÚ¸®¼ö°¡ ¶È°°À½?
		
		if(n <= threshold) {
			return x*y;
		}
		
		int m = n/2;
		long Bm = (long)Math.pow(10, m);
		
		long x1 = x/Bm;
		long x0 = x-(x1*Bm);
		long y1 = y / Bm;
		long y0 = y - (y1*Bm);
		
		long z2 = mul(x1,y1);
		long z0 = mul(x0, y0);
		long z1 = mul(x1+x0,y1+y0) - z2-z0;
		
		return (z2*(long)Math.pow(10, 2*m)) + (z1*(long)Math.pow(10,  m)) + z0;
	}
	public int getThreshold(long n) {
		int count = 0;
		while(n !=0 ) {
			count++;
			n /= 10;
		}
		return count;
	}
}

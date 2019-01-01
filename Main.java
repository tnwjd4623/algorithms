package hw13;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) {
		Matrix_Chain_Multiplication m = new Matrix_Chain_Multiplication();
		int size = 0;
		
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		StringTokenizer t = new StringTokenizer(str, " ");
		
		t.nextToken();t.nextToken();			

		int p = Integer.parseInt(t.nextToken());
		t.nextToken();
		int q = Integer.parseInt(t.nextToken());
		
		m.addFirst(p, q);
		size++;
		while(true) {
			String str2 = scan.nextLine();
			if(str2.equals("0"))
				break;
			
			StringTokenizer t2 = new StringTokenizer(str2, " ");
			
			t2.nextToken();t2.nextToken();			
	
			int p2 = Integer.parseInt(t2.nextToken());
			t2.nextToken();
			int q2 = Integer.parseInt(t2.nextToken());
			
			m.addMatrix(q2);
			size++;
		}
		
		m.Matrix_Chain_Order();
		System.out.println("----------------------------------------------------------");
		m.printMArray();
		System.out.println("----------------------------------------------------------");
		m.printSArray();
		System.out.println("----------------------------------------------------------");

		
		
		m.printOptimalSolution();
		System.out.print("Optimal parens : ");
		m.Print_Optimal_Parens(1, size);
	}
}

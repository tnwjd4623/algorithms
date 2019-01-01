package algorithm00_hw10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		Knapsack knapsack = new Knapsack();
		
		//input file path
		File file = new File("C:\\Users\\lsj95\\Desktop\\data11.txt");
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String str = reader.readLine();
		
		while(str!=null) {
			StringTokenizer t = new StringTokenizer(str, ",");
			
			while(t.hasMoreTokens()) {
				knapsack.addItem(Integer.parseInt(t.nextToken()), 
						Integer.parseInt(t.nextToken()), 
						Integer.parseInt(t.nextToken()));
			}
			str = reader.readLine();
		}
		
		
		knapsack.knapsack(11);
	}

}

package hw12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException {
		File file = new File("C:\\Users\\lsj95\\Desktop\\data12.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String str = reader.readLine();
		String str2 = reader.readLine();
		
		
		Sequence_alignment s = new Sequence_alignment(str, str2);
		
		s.Seqence_alignment();
	}
}

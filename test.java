package hw09;

public class test {
	public static void main(String args[]) {
		String v[] = {"a", "b", "c", "d", "e", "f", "g", "h","i"};
		
		Prim p = new Prim(9);
		p.addVertex(v);
		
		p.addPath("a","b",4);
		p.addPath("a","h",8);
		p.addPath("b","c",8);
		p.addPath("b","h",11);
		
		p.addPath("c","d",7);
		p.addPath("c","f",4);
		p.addPath("c","i",2);
		
		p.addPath("d","e",9);
		p.addPath("d","f",14);
		p.addPath("e","f",10);
		
		p.addPath("f","g",2);
		p.addPath("g","i",6);
		p.addPath("g","h",1);
		
		p.addPath("h","i",7);
		
		p.prim();
		p.print();
	}

}

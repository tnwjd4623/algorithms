package hw07;

public class test {
	public static void main(String[] args) {
		Dijkstra d = new Dijkstra(5);
		String v[] = new String[]{"A","B","C","D","E"};
		
		d.addVertex(v);	//정점 추가하기, 인자는 배열
		
		
		//Edge 추가하기 String, String, Integer
		d.addPath("A", "B", 10);
		d.addPath("A", "C", 3);
		d.addPath("B", "D", 2);
		d.addPath("B", "C", 1);
		d.addPath("C", "B", 4);
		d.addPath("C", "D", 8);
		d.addPath("C", "E", 2);
		d.addPath("D", "E", 7);
		d.addPath("E", "D", 9);
		d.Dijkstra();
	
		
		
		
		
	}
}

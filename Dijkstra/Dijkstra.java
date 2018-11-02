package hw07;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Dijkstra {
	private int[][] w;
	private int[] d;
	private String[] S;
	private Vertex[] vertex;
	private PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();
	
	public class Vertex implements Comparable<Vertex>{
		String v;
		int distance;
		
		public Vertex(String v, int d) {
			this.v = v;
			distance = d;
		}
		public void setDistance(int d) {
			distance = d;
		}
		@Override
		public int compareTo(Vertex target) {
			if(this.distance > target.distance)
				return 1;
			else if(this.distance < target.distance)
				return -1;
			
			return 0;
		}
		@Override
		public String toString() {
			return v;
		}
	}
	public Dijkstra(int n) {
		w = new int[n][n];
		d = new int[n];
		S = new String[n];
		
		d[0] = 0;		// Start
		for(int i = 1; i<n; i++) {
			d[i] = 210000000;
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				w[i][j] = 210000000;
			}
			w[i][i] = 0;
		}
	}
	public void addPath(String a, String b, int c) {
		int i=getIndex(a);
		int j = getIndex(b);
		
		w[i][j] = c;
		
	}
	public int getIndex(String v) {
		int i = 0;
		for(i = 0; i<vertex.length; i++) {
			if(v.equals(vertex[i].v)) {
				return i;
			}
		}
		return i;
	}
	public void addVertex(String[] v) {	
		vertex = new Vertex[v.length];
		
		vertex[0] = new Vertex(v[0], 0);
		Q.add(vertex[0]);
		for(int i = 1; i<v.length; i++) {
			vertex[i] = new Vertex(v[i], Integer.MAX_VALUE);
			Q.add(vertex[i]);
		}
	}
	
	public void Dijkstra() {
		int i = 0;
		
		while(!Q.isEmpty()) {
			Vertex root = Q.poll();
			System.out.println("天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天");
			System.out.println("S["+i+"] : d["+root.v+"] = "+root.distance);
			S[i++] = root.v;
			int u = getIndex(root.v);
			
			PriorityQueue<Vertex> tmp_Q = new PriorityQueue<Vertex>(Q);
			int j = 0;
			System.out.println("-------------------------------------------");
			while(!tmp_Q.isEmpty()) {
				Vertex tmp = tmp_Q.poll();
				System.out.print("Q["+(j++)+"] : d["+tmp.v+"] = "+tmp.distance);
				int v = getIndex(tmp.v);
				
				if(d[u]+w[u][v] < d[v]) {
					d[v] = d[u]+w[u][v];
					System.out.println("\t->d["+tmp.v+"] = "+d[v]);
				}
				else {
					System.out.println("");
				}
			}
			
			while(!Q.isEmpty()) {
				Vertex v = Q.poll();
				int index = getIndex(v.v);
				v.setDistance(d[index]);
				tmp_Q.add(v);
			}
			
			while(!tmp_Q.isEmpty()) {
				Q.add(tmp_Q.poll());
			}
		}
		
	}
	public void printQ() {
		Iterator iterator = Q.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	public void printS() {
		for(int i=0; i<5; i++) {
			System.out.println(S[i]);
		}
	}
}

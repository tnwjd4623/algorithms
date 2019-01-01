package hw09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Prim {
	private PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();
	private int[] key;
	private int[][] w;
	private Vertex[] vertex;
	private Adj[] adj;
	private String[] parent;
	
	public class Vertex implements Comparable<Vertex> {
		String v;
		int key;
		public Vertex(String s, int k) {
			v = s;
			key = k;
		}
		@Override
		public int compareTo(Vertex target) {
			if(this.key > target.key)
				return 1;
			else if(this.key < target.key)
				return -1;
			else if(this.key == target.key) {
				if(this.key > target.key)
					return 1;
				else
					return -1;
			}
			return 0;
		}
		@Override
		public boolean equals(Object obj) {
			String target = (String)obj;
			if(v.equals(target)) {
				return true;
			}
			else 
				return false;
		}
	}
	public class Adj {
		String parent;
		ArrayList<String> adj = new ArrayList<String>();
		
		public Adj(String parent) {
			this.parent = parent;
		}
		public void addV(String a) {
			adj.add(a);
		}
	}
	public Prim(int n) {
		key = new int[n];
		w = new int[n][n];
		vertex = new Vertex[n];
		adj = new Adj[n];
		parent = new String[n];
		
		key[0] = 0;
		for(int i = 1; i<n; i++) {
			key[i] = 210000000;
		}
		for(int i = 0; i<n; i++) {
			parent[i] = "";
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
		adj[i].addV(b);
		adj[j].addV(a);
		
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
		adj = new Adj[v.length];
		
		vertex[0] = new Vertex(v[0], 0);
		adj[0] = new Adj(v[0]);
		
		Q.add(vertex[0]);
		for(int i = 1; i<v.length; i++) {
			vertex[i] = new Vertex(v[i], 210000000);
			adj[i] = new Adj(v[i]);
			Q.add(vertex[i]);
		}
	}
	
	public void prim() {
		
		while(!Q.isEmpty()) {
			Vertex u = Q.poll();
			int index = getIndex(u.v);		//u index
			
			Adj a = adj[index];
			
			for(int i = 0;i<a.adj.size(); i++) {
				String v = a.adj.get(i);
				Iterator iterator = Q.iterator();
				while(iterator.hasNext()) {
					int j = getIndex(v);		// v index
					
					if(iterator.next().equals(v)&& w[index][j]< vertex[j].key) {
						vertex[j].key = w[index][j];
						parent[j] = u.v;
					}
				}
			}
			
			PriorityQueue<Vertex> tmp_Q = new PriorityQueue<Vertex>(Q);
			Q = new PriorityQueue<Vertex>();
			while(!tmp_Q.isEmpty()) {
				Q.add(tmp_Q.poll());
			}
		}
	}
	
	public void print() {	
		System.out.println("w< ,a> = 0");
		for(int i = 0; i<vertex.length; i++) {
			for(int j = 0; j<parent.length; j++) {
				if(vertex[i].v.equals(parent[j])) {
					System.out.println("w<"+vertex[i].v+","+vertex[j].v+"> = "+vertex[j].key);
				}
			}
		}
		
		int sum=0;
		for(int i = 0; i<vertex.length; i++) {
			sum+=vertex[i].key;
		}
		System.out.println("\nw<MST> = "+sum);
	}
}

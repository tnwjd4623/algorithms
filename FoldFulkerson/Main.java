package hw14;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class Main {
	static int INF = 987654321;
	static int V = 6;
	static int[][] capacity;
	static int[][] flow;
	
	public static void main(String args[]) {
		capacity = new int[6][6];
		
		capacity[0][1] = 12;
		capacity[0][3] = 3;
		
		capacity[1][2] = 10;
		
		capacity[2][4] = 3;
		capacity[2][5] = 15;
		
		capacity[3][1] = 11;
		capacity[3][4] = 5;
		
		capacity[4][5] = 17;
		

		System.out.println("유량 네트워크 전체의 최대 용량: "+networkFlow(0, 5));
	}
	
	public static int networkFlow(int source, int sink) {
		flow = new int[6][6];
		Stack path = new Stack();
		int totalFlow = 0;
		
		while(true) {
			int[] parent = new int[6];
			for(int i = 0; i<6; i++) {
				parent[i] = -1;
			}
			Queue<Integer> q = new LinkedList<Integer>();
			
			parent[source] = source;
			q.add(source);
			
			while(!q.isEmpty() && parent[sink] == -1) {
				int here = q.poll();
				for(int there = 0; there<V; there++) {
					if(capacity[here][there] - flow[here][there]>0 
							&& parent[there] == -1)  {
						q.add(there);//System.out.println(here+" "+there);
						parent[there] = here;
					}
				}
			}
		
			if(parent[sink] == -1) break;
			
			int amount = INF;
			
			for(int p = sink; p!=source; p=parent[p]){
				//capacity 중 최소 값
				amount = Math.min(capacity[parent[p]][p] - flow[parent[p]][p], amount);
			}
			for(int p = sink; p!=source; p=parent[p]){
				flow[parent[p]][p] += amount;			//흐르는 유량
				flow[p][parent[p]] -= amount;			//잔여 유량
				path.push(p);
			}
			System.out.print("경로: 0 ");
			while(!path.isEmpty()) {
				System.out.print(path.pop()+" ");
			}
			totalFlow += amount;
			
			System.out.println("/ 최대 용량:"+amount);
		}
		
		
		return totalFlow;
	}
}

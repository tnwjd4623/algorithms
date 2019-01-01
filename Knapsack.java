package algorithm00_hw10;

import java.util.ArrayList;

public class Knapsack {
	class item {
		int number;
		int value;
		int weight;
		
		public item(int number, int value, int weight) {
			this.number = number;
			this.value = value;
			this.weight = weight;
		}
	}
	class itemList {
		ArrayList<Integer> list;
		
		public itemList() {
			list = new ArrayList<Integer>();
		}
		public void addList(int n) {
			list.add(n);
		}
		@Override
		public String toString() {
			String str = "";
			for(int i = 0; i<list.size(); i++) {
				str += list.get(i)+" ";
			}
			return str;
		}
	}
	
	private item[] item = new item[100000];
	private int[][] OPT;
	private itemList[][] itemlist = new itemList[0][0];
	private int index;
	
	public Knapsack() {
		index = 0;
		item[index++] = new item(0, 0, 0);
	}
	public void addItem(int number, int value, int weight) {
		item[index++] = new item(number,value, weight);
	}
	
	public void knapsack(int size) {
		itemlist = new itemList[index][size+1];
		OPT = new int[index][size+1];
		
		//init OPT & itemlist 
		for(int i = 0; i<index; i++) {
			for(int j = 0; j<=size; j++) {
				OPT[i][j] = 0;
				itemlist[i][j] = new itemList();
			}
		}
		
		//OPT 1 ~ size ±¸ÇÏ±â
		for(int i = 0; i<index; i++) {
			for(int j = 0; j<=size; j++) {
				OPT(i, j);
			}
		}
		
		//print OPT 0 ~ size
		for(int i = 0; i<index; i++) {
			for(int j = 0; j<=size; j++) {
				System.out.print(OPT[i][j]+"\t");
			}
			System.out.println("");
		}
		
		//print max & itemList
		System.out.println("max : "+OPT[index-1][size]);
		System.out.println("item : "+itemlist[index-1][size]);
		
	}
	public int OPT(int i, int w) {
		if(i==0){
			return 0;
		}
		if(item[i].weight > w) {
			OPT[i][w] = OPT[i-1][w];
			itemlist[i][w] = itemlist[i-1][w];
			return OPT[i][w];
		}
		else {
			int a = OPT[i-1][w];
			int b = item[i].value + OPT[i-1][w-item[i].weight];
			
			if(a>b){
				OPT[i][w] = a;
				itemlist[i][w] = itemlist[i-1][w];
				return OPT[i][w];
			}
			else{
				OPT[i][w] = b;
				itemlist[i][w].list.addAll(itemlist[i-1][w-item[i].weight].list);
				itemlist[i][w].addList(i);
				return OPT[i][w];
			}
		}
		
	}
}

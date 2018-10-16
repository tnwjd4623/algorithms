package hw02;

public class Heap {
	private Node node[] = new Node[10000];
	private int index = 1;
	private int size = 0;
	
	public Heap(int size) {
		Node root = new Node(0, "root");
		node[0] = root;
		this.size = size;		// index 1부터
	}
	public void Max_Heapify(int parent) {
		int left = 2*parent;
		int right = 2*parent+1;
		int largest = parent;
		
		if(left<=size && node[left].getKey() > node[parent].getKey()) {
			largest = left;	
		}
		if(right<=size && node[right].getKey() > node[parent].getKey()){
			largest = right;
		}
		
		if(largest!=parent) {
			Node tmp = node[parent];
			node[parent] = node[largest];
			node[largest] = tmp;
			
			Max_Heapify(largest);
		}
			
		
	}
	public void Build_Max_Heap() {
		for(int i = size/2; i>=1; i--) {
			Max_Heapify(i);
		}
	}
	public void insert(Node n) {
		if(index > size) {
			size++;
		}
		node[index++] = n;
	}
	public void extractMax() {
		node[1] = node[size--];
		Build_Max_Heap();
		
	}
	public void increase_key(int old_key, int new_key) {
		for(int i=1; i<=size; i++) {
			if(node[i].getKey()==old_key) {
				node[i].setKey(new_key);
			}
		}
		Build_Max_Heap();
	}
	public void delete(int key) {
		for(int i = 1; i<=size; i++) {
			if(node[i].getKey() == key) {
				node[i] = node[size--];
				Build_Max_Heap();
			}
		}
	}
	public void printMax() {
		System.out.println("최대값: "+node[1].toString());
	}
	public void printHeap() {
		for(int i = 1; i<=size; i++) {
			System.out.println(node[i].toString());
		}
	}
}

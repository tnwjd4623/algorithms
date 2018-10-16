package hw02;

public class Node {
	private int key;
	private String subject;
	
	public Node(int k, String s) {
		this.key = k;
		this.subject = s;
	}
	
	public int getKey() {
		return key;
	}
	public String getSubject() {
		return subject;
	}
	public void setKey(int k) {
		this.key = k;
	}
	@Override
	public String toString() {
		return this.key+". "+this.subject;
	}
	@Override
	public boolean equals(Object o) {
		Node n = (Node) o;
		if(this.key==n.getKey() && this.subject.equals(n.getSubject()))
			return true;
		
		return false;
	}
}

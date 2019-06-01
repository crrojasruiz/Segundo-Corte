import java.util.Vector;

public class EdgeNode {
	int weight;
	int label;

	private EdgeNode next;

	public EdgeNode(int weight, int label){
		this.weight = weight;
		this.label = label;
	}

	public void setNext(EdgeNode next){
		this.next = next;
	}

	public EdgeNode getNext(){
		return this.next;
	}

	public String toString(){
		String data = ("label: " + this.label + "\tCosto: %d" + this.weight + "" +this.label);
		return data;
	}
	
	public boolean isEqual(EdgeNode node){
		boolean result = false;
		
		if(this.label == node.label)
			result = true;
		
		return result;
	}


}

package Arboles;

import ListNodeQueueStack.Node;

public class MemoryNode implements Node {

	@Override
	public void setNext(Node node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Node getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node clone() {
		// TODO Auto-generated method stub
		return new AVLNodeExample(this.value);
	}

	@Override
	public boolean isEqual(Node node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLessThan(Node node) {
		// TODO Auto-generated method stub
		return false;
	}

}

package Arboles;

import ListNodeQueueStack.Node;

public class BinaryTree {

	BinaryTreeNode root = null; //

	/**
	 * 
	 */
	public BinaryTree() {}


	/**
	 * 
	 * @return
	 */
	public boolean isEmpty()
	{
		return root == null ? true : false;
	}


	/**
	 * 
	 * @param value
	 */
	public void insert(BinaryTreeNode node)
	{
		if(isEmpty())
		{
			root = node;
		}
		else
		{
			BinaryTreeNode temp = root;
			BinaryTreeNode parent = root;

			while(temp != null)
			{
				parent = temp;
				if(node.isLessThan(temp))
					temp = temp.getLeft();
				else
					temp = temp.getRight();
			}

			if(node.isLessThan(parent))
				parent.setLeft(node);
			else
				parent.setRight(node);
		}
	}


	/**
	 * 
	 * @param value
	 * @return
	 */
	public BinaryTreeNode search(BinaryTreeNode nodeToSearch)
	{
		BinaryTreeNode temp = root;

		while(temp != null)
		{
			if(temp.isEqual(nodeToSearch))
				break;
			else
				if(nodeToSearch.isLessThan(temp))
					temp = temp.getLeft();
				else
					temp = temp.getRight();
		}

		return temp;
	}

	public Node getParent(BinaryTreeNode Node)
	{
		BinaryTreeNode temp = root;
		BinaryTreeNode parent = root;

		while(temp != null)
			if(Node.isEqual(temp))
				break;
			else
				parent = temp;
		if(Node.isLessThan(temp))
			temp = temp.getLeft();
		else
			temp =temp.getRight();

		return (ListNodeQueueStack.Node) parent;
	}

	public void delete(BinaryTreeNode nodeToDelete)
	{
		if(isLeaf(nodeToDelete))
		{
		}
		else
		{
			if(oneChild(nodeToDelete))
			{
			}
		}
	}
}


/**
 * 
 * @param node
 * @return
 */
public boolean isLeaf(BinaryTreeNode node)
{
	return (node.getLeft() == null && node.getRight() == null) ? true : false;
}


/**
 * 
 * @param node
 * @return
 */
public boolean oneChild(BinaryTreeNode node)
{
	return (node.getLeft() != null && node.getRight() != null) ? false : true;
}


/**
 * 
 * @param node
 */
public void preorder(BinaryTreeNode node)
{
	if(node != null)
	{
		System.out.print(node.toString() + " ");
		preorder(node.getLeft());
		preorder(node.getRight());
	}
}


/**
 * 
 * @param node
 */
public void postorder(BinaryTreeNode node)
{
	if(node != null)
	{
		postorder(node.getLeft());
		postorder(node.getRight());
		System.out.print(node.toString() + " ");
	}

}


/**
 * 
 * @param node
 */
public void inorder(BinaryTreeNode node)
{
	if(node != null)
	{
		inorder(node.getLeft());
		System.out.print (node.toString() + " ");
		inorder(node.getRight());
	}

}
}
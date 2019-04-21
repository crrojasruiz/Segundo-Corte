package EjerciciosDeMaratones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


import ListNodeQueueStack.List;
import ListNodeQueueStack.Node;
import ListNodeQueueStack.Queue;
import EjerciciosDeMaratones.BUBBLE_SORT;

//https://www.urionlinejudge.com.br/judge/en/problems/view/1211

public class EconomicPhonebook 
{
	public class ProblemNode implements Node
	{
		public int[] data;
		public ProblemNode next=null;
		ProblemNode(int[] data)
		{
			this.data=data;
		}
		public String toString() 
		{
			return Arrays.toString(this.data)+"\n";
		}
		@Override
		public void setNext(Node node) 
		{
			// TODO Auto-generated method stub
			this.next=(ProblemNode)node;
		}
		@Override
		public Node getNext() 
		{
			// TODO Auto-generated method stub
			return next;
		}
		@Override
		public Node clone() 
		{
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean isEqual(Node node) 
		{
			// TODO Auto-generated method stub
			ProblemNode temp = (ProblemNode)node;
			return this.data == temp.data ? true : false;
		}
		@Override
		public boolean isLessThan(Node node) {
			boolean res= false;
			ProblemNode temp = (ProblemNode)node;
			for (int i = 0; i < data.length; i++) {
				if(data[i]<(int)temp.data[i]) {
					res=true;
					break;
				}
				else if(data[i]>temp.data[i]) {
					res=false;
					break;
				}
			}
			return res;
		}
	}
	public void solution() {
		EconomicPhonebook b=new EconomicPhonebook();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			String s=br.readLine();
			int cuenta=0;
			while(s!=null) {
				List x= new List();
				int cases=Integer.parseInt(s);
				for (int i = 0; i < cases; i++) {

					String[] input=br.readLine().split("");
					int[] node=new int[input.length];
					for (int j = 0; j < input.length; j++) {

						node[j]=Integer.parseInt(input[j]);
					}

					x.insertAtEnd(new ProblemNode(node));
				}
				x.BUBBLE_SORT(x);
				x.printList();

				ProblemNode temp=(ProblemNode)x.head;
				while(temp!=null) {
					ProblemNode one= temp;
					ProblemNode two=(ProblemNode)temp.getNext();
					//counts how many characters are saved comparing one node with the next.
					for (int i = 0; i < one.data.length; i++) {

						if(one.data[i]==two.data[i]) {

							cuenta++;
						}
						else {
							break;
						}

					}
					temp=(ProblemNode)temp.getNext();
					one=two;
					
					//print the result
				}
				bw.write(cuenta+"\n");
				bw.flush();
				s=br.readLine();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
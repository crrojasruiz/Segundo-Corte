import java.io.*;
import java.util.Vector;

public class Graph_LE {

	public class GraphNode{
		int data;
		int label;
		boolean visited = false;
		int estimated_cost = Integer.MAX_VALUE;
		int label_previous = -1;
		Vector<EdgeNode> edges = new Vector<EdgeNode>();
		private GraphNode next;

		public GraphNode(int data,int label){
			this.data = data;
			this.label = label;
		}
		public void setNext(GraphNode next){
			this.next = next;
		}

		public GraphNode getNext(){
			return this.next;
		}

		public String toString(){

			String data=("label: " + this.label + "\tData: %d" + this.data +""+ this.label);
			return data;
		}

		public boolean isEqual(GraphNode node){
			boolean result = false;
			if(this.data == node.data)
				result = true;
			return result;
		}
		public int degree() {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	Vector<GraphNode> nodes = new Vector<GraphNode>();

	public Graph_LE(){}

	public void insert_node(int label,int data){
		nodes.add( new GraphNode(data, label) );
	}

	public void delete_node(int label){
		GraphNode toSearch = new GraphNode(0,label);
		for(int i = 0; i < nodes.size(); i++)
			if(nodes.get(i).equals(toSearch)){
				nodes.remove(i);
				break;
			}
			else
				for(int j = nodes.get(i).edges.size() -1; j>=0; j--)
					if(nodes.get(i).edges.get(j)==label)
						nodes.get(i).edges.remove(j);
	}

	public void insert_edge(int label_1,int label_2){
		GraphNode toSearch = new GraphNode(0,label_1);
		for(int i = 0; i < nodes.size(); i++)
			if(nodes.get(i).equals(toSearch)){
				nodes.get(i).edges.add(label_2);
				break;
			}
		toSearch = new GraphNode(0, label_2);
		for(int i = 0; i < nodes.size();i++)
			if(nodes.get(i).equals(toSearch)){
				nodes.get(i).edges.add(label_1);
				break;
			}
	}

	public boolean if_exists(int label){
		GraphNode toSearch = new GraphNode(0, label);
		for(int i = 0; i < nodes.size(); i++)
			if(nodes.get(i).equals(toSearch))
				return true;
		return false;
	}
	public GraphNode max_degree(){
		GraphNode winner = null;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<nodes.size(); i++)
			if(nodes.get(i).degree() > max){
				max= nodes.get(i).degree();
				winner = nodes.get(i);
			}
		return winner;
	}

	public static void main (String[]args){
		Graph_LE graph = new Graph_LE();
		
		try{
			FileReader fr = new FileReader("data.txt");
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader( fr );
			@SuppressWarnings("resource")
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(null));
			bw.write("Start...\n");
			int label,counter = 1;
			String line = br.readLine();
			String[] record = null;
			bw.write("Reading file...\n");
			while(line != null){
				bw.write("Register" + counter);
				record = line.split(" ");
				for(int i = 0;i < 2; i++ ){
					label = Integer.parseInt(record[i]);
				if(!graph.if_exists(label))
						graph.insert_node(label,1);
				}
				graph.insert_edge(Integer.parseInt(record[0]),
						Integer.parseInt(record[1]));
				counter +=1;
				line = br.readLine();
			}
			bw.write(graph.nodes.toString());
			for(int i = 0; i < graph.nodes.size(); i++);
		
		}	
	
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}



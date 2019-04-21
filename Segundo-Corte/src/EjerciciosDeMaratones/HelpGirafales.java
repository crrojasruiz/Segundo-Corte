package EjerciciosDeMaratones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class HelpGirafales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	       BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	       try {
			String s= br.readLine();
			while(s!="0") {
				int originalsig=Integer.parseInt(s);
				HashMap<String, String> map = new HashMap<String, String>();
				for (int i = 0; i <originalsig; i++) {
					String[]input= br.readLine().split(" ");
					map.put(input[0], input[1]);
				}
				
				int signaturesDay=Integer.parseInt(br.readLine());
				int res=0;
				for (int i = 0; i < signaturesDay; i++) {
					
					String[] input2= br.readLine().split(" ");
					if(!map.get(input2[1]).equals((input2[0]))) {
						res--;
						
					}
				}
				bw.write(res+"\n");
				bw.flush();
				
				
				
				s=br.readLine();
			}
	    	   
	    	   
	    	   
	    	   
	    	   
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
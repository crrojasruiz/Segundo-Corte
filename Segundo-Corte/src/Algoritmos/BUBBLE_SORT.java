package Algoritmos;
import java.util.Scanner;
public class BUBBLE_SORT {
	public static void main(String[] args) {	
		int [] a={1,4,5,6,3,2,7};
		bubble_sort(a);
	}
	public static void bubble_sort(int[]a){
		int temp;
		boolean swapped = false;
		do{
			for (int i = 0; i < a.length-1; i++) {
				if(a[i] > a[i+1]){
					temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					swapped = true;
				}
			}
		}
		while(swapped);
	}	
}


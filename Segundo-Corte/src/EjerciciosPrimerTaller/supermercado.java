package EjerciciosPrimerTaller;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class supermercado{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);  
		String nombres [] = {"arroz   ", "aceite   ", "mantequilla ", "cereales", "yogurt   ", "cerveza   ", "frijol   ", "pasta   "};
		int productos [][] = {{1500,50},
				{17000,50},
				{3500,50},
				{1700,50},
				{2200,50},
				{3000,50},
				{3200,50},
				{3000,50}};
		int opcion;        
		int ventas = 0;              
		do {
			opcion = lee_opcion_menu();        
			switch (opcion) {
			case 1:
				listar_productos(nombres, productos);
				break;                
			case 2:
				ventas = vender_productos(nombres, productos) + ventas;
				break;                
			case 3:
				mostrar_total_de_ventas(ventas);
				break;                

			}
		} while (opcion != 0);

		System.out.println("Gracias por sus compras!");

	}

	static int lee_opcion_menu() {
		int opcion;

		do {
			System.out.println("Elige una opción");
			System.out.println("1.- Listar productos");
			System.out.println("2.- Realizar venta");
			System.out.println("3.- Mostrar total de ventas");
			System.out.println("0.- Salir");

			opcion = sc.nextInt();

		} while (opcion < 0 || opcion >3);

		return opcion;
	}

	static void listar_productos(String nombres[], int productos[][]) {
		int i = 0;
		System.out.println("\tProducto\tPrecio\tCantidad");
		for (i = 0;i<productos.length;i++) {
			System.out.println((i+1)+".\t"+nombres[i]+"\t"+productos[i][0]+"\t"+productos[i][1]);
		}
	}

	static int vender_productos(String nombres[], int productos[][]) {
		int i = 0;
		int opcion;
		int existencias;
		int comprados;
		int total = 0;

		do {
			System.out.println("Qué producto deseas comprar?");
			listar_productos(nombres, productos);

			opcion = sc.nextInt();

		} while (opcion < 1 || opcion > productos.length);


		existencias = productos[opcion-1][1];

		if(existencias > 0) {
			do {
				System.out.println("Cuantos productos desea comprar (1-"+existencias+")?");
				comprados = sc.nextInt();

			} while (comprados < 1 || comprados > existencias);


			System.out.println("Venta: "+nombres[opcion-1]);

			total = productos[opcion-1][0] * comprados;

			System.out.println("Por favor pague la cantidad de: "+total);

			productos[opcion-1][1] = existencias - comprados;
		} else {            
			System.out.println("Lo siento, no tenemos ese producto en existencia");
		}

		espera_tecla();

		return total;

	}

	static void mostrar_total_de_ventas(int total) {
		System.out.println("El total de ventas ha sido de: "+total);
		espera_tecla();
	}

	static void espera_tecla() {

		System.out.println("Presione una tecla para continuar");
		sc.nextLine();
		sc.nextLine();
	}
}

*/
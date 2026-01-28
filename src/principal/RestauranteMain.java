package principal;

import java.util.Scanner;

public class RestauranteMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        int opcion;
	        
	        Partida partida = new Partida();

	        do {
	            menuInicio();
	            System.out.print("👉 Elige una opción: ");
	            opcion = sc.nextInt();

	            switch (opcion) {
	                case 1:
	                    menuTienda();
	                   opcion = sc.nextInt();
	                   Lechuga l = new Lechuga();
	                   
	                   partida.ingredientesDisponibles.add(l,1);
	                   
	                   switch(opcion) {
	                   
	                   case 1: System.out.println("");
	                   
	                   
	                   
	                   
	                   }
	                case 2:
	                    System.out.println("\n⭐ Mostrando puntuación del restaurante...\n");
	                    break;
	                case 3:
	                    System.out.println("\n👋 Cerrando el restaurante... ¡Hasta mañana!\n");
	                    break;
	                default:
	                    System.out.println("\n❌ Opción no válida, intenta otra vez.\n");
	            }

	        } while (opcion != 3);

	        sc.close();
	    }

	    public static void menuInicio() {
	    	
	    	
	    	System.out.println("====================================");
	    	System.out.println("         BIENVENIDO AL RESTAURANTE");
	    	System.out.println("====================================");
	    	System.out.println();
	    	System.out.println("1 - Comprar ingredientes");
	    	System.out.println("2 - Mejorar ingredientes/equipo");
	    	System.out.println("3 - Abrir restaurante");
	    	System.out.println("4 - Salir");
	    	System.out.println();
	    	System.out.println("====================================");
	    	System.out.print("Elige una opción: ");

	    }
	    
	    public static void menuTienda() {
	    	System.out.println("====================================");
	    	System.out.println("           TIENDA DEL RESTAURANTE");
	    	System.out.println("====================================");
	    	System.out.println();
	    	System.out.println("1 - Comprar Lechuga");
	    	System.out.println("2 - Comprar Carne");
	    	System.out.println("3 - Comprar Pan");
	    	System.out.println("4 - Volver al menú principal");
	    	System.out.println();
	    	System.out.println("====================================");
	    	System.out.print("Elige una opción: ");

	    }
	}
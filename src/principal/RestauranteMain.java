package principal;

import java.util.Scanner;

public class RestauranteMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        int opcion;

	        do {
	            mostrarMenu();
	            System.out.print("👉 Elige una opción: ");
	            opcion = sc.nextInt();

	            switch (opcion) {
	                case 1:
	                    System.out.println("\n🧑‍🍳 Atendiendo a un nuevo cliente...\n");
	                    break;
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

	    public static void mostrarMenu() {
	        System.out.println("=======================================");
	        System.out.println(" 🍽️   BIENVENIDO A JAVA RESTAURANT   🍽️");
	        System.out.println("=======================================");
	        System.out.println(" 1️⃣  Atender nuevo cliente");
	        System.out.println(" 2️⃣  Ver puntuación del restaurante");
	        System.out.println(" 3️⃣  Salir");
	        System.out.println("=======================================");
	    }
	}